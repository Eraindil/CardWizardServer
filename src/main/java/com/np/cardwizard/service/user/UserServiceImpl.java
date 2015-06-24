package com.np.cardwizard.service.user;

import com.np.cardwizard.model.user.User;
import com.np.cardwizard.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public User getUser(String email) {
    return userRepository.findByEmail(email);
  }

  @Override
  public void updateUser(User user) {
    userRepository.save(user);
  }

  @Override
  public void createUser(User user) {
    userRepository.save(user);
  }

  @Override
  public void deleteUser(String email) {
    userRepository.delete(email);
  }

  @Override
  public void deleteUser(User user) {
    userRepository.delete(user);
  }
}
