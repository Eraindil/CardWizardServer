package com.np.cardwizard.service.user;

import com.np.cardwizard.model.user.User;

public interface UserService {

  User getUser(String email);

  void updateUser(User user);

  void createUser(User user);

  void deleteUser(String email);

  void deleteUser(User user);
}
