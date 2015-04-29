package com.np.cardwizard.repository;

import com.np.cardwizard.model.user.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
  User findByEmail(String email);
}
