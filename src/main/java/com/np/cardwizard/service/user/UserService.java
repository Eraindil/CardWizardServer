package com.np.cardwizard.service.user;

import com.np.cardwizard.model.user.User;

public interface UserService {

  User getUser(int userId);

  void updateUser(User user);

  void createUser(User user);

  void deleteUser(int userId);
}
