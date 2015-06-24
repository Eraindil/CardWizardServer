package com.np.cardwizard.converter;

import com.np.cardwizard.dto.UserDTO;
import com.np.cardwizard.model.user.User;
import com.np.cardwizard.model.user.UserRole;
import org.springframework.stereotype.Component;

@Component
public class UserToDTOConverter implements BaseDTOConverter<User, UserDTO> {
  @Override
  public UserDTO convertToDTO(User user) {
    UserDTO userDTO = new UserDTO();
    userDTO.setEmail(user.getEmail());
    userDTO.setUserName(user.getUserName());
    userDTO.setRole(user.getRole().toString());
    return userDTO;
  }

  @Override
  public User convertFromDTO(UserDTO userDTO) {
    User user = new User();
    user.setEmail(userDTO.getEmail());
    user.setUserName(userDTO.getUserName());
    user.setRole(UserRole.valueOf(userDTO.getRole()));
    return user;
  }
}
