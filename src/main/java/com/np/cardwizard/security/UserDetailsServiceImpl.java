package com.np.cardwizard.security;

import com.np.cardwizard.model.User;
import com.np.cardwizard.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Collections;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  private static final Logger LOGGER = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

  private final MessageSourceAccessor messages = SpringSecurityMessageSource.getAccessor();

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user;

    try {
      user = userRepository.findByEmail(username);
      if (user == null) {
        LOGGER.error("user name not found");
        throw new UsernameNotFoundException("user name not found");
      }

    } catch (EntityNotFoundException e) {
      throw new UsernameNotFoundException("database error ");
    }
    return buildUserFromUserEntity(user);
  }

  private org.springframework.security.core.userdetails.User buildUserFromUserEntity(User user) {
    // convert model user to spring security user
    String username = user.getEmail();
    String password = user.getPassword();
    boolean enabled = true;
    boolean accountNonExpired = true;
    boolean credentialsNonExpired = true;
    boolean accountNonLocked = true;
    List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority(user.getRole().toRoleString()));

    org.springframework.security.core.userdetails.User springUser = new org.springframework.security.core.userdetails.User(username, password, enabled,
        accountNonExpired, credentialsNonExpired, accountNonLocked,
        authorities);
    return springUser;
  }
}
