package com.np.cardwizard.security;

import com.np.cardwizard.model.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class UserDetails extends User {

  private static final long serialVersionUID = 1L;

  private final String email;
  private final UserRole role;
  private String language;

  public UserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities, String email, UserRole role,
                     String language) {

    super(username, password, authorities);
    this.email = email;
    this.role = role;
    this.language = language;
  }

  public UserDetails(String username, String password, boolean enabled, boolean accountNonExpired,
                     boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities, String email,
                     UserRole role, String language) {

    super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    this.email = email;
    this.role = role;
    this.language = language;
  }

  public String getEmail() {
    return email;
  }

  public UserRole getRole() {
    return role;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }
}
