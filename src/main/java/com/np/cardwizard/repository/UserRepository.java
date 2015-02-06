package com.np.cardwizard.repository;

import com.np.cardwizard.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
  public User findByEmail(String email);
}
