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
  public User getUser(int userId) {
    return null;
  }

  @Override
  public void updateUser(User user) {

  }

  @Override
  public void createUser(User user) {

  }

  @Override
  public void deleteUser(int userId) {

  }
}
