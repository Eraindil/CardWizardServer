package com.np.cardwizard.rest;

import com.np.cardwizard.converter.UserToDTOConverter;
import com.np.cardwizard.dto.UserDTO;
import com.np.cardwizard.dto.UserRegistrationDTO;
import com.np.cardwizard.model.user.User;
import com.np.cardwizard.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RestController
public class UserController {
  @Autowired
  private UserService userService;

  @Autowired
  private UserToDTOConverter userToDTOConverter;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @RequestMapping(method = RequestMethod.GET)
  public UserDTO getUser(@RequestParam String email) {
    return userToDTOConverter.convertToDTO(userService.getUser(email));
  }

  @RequestMapping(method = RequestMethod.POST)
  public void registerUser(@RequestBody UserRegistrationDTO userRegistrationDTO) {
    if (userService.getUser(userRegistrationDTO.getEmail()) == null) {
      if (userRegistrationDTO.getPassword() != null
          && userRegistrationDTO.getPassword().equals(userRegistrationDTO.getPasswordConfirmed())) {
        User user = new User();
        user.setEmail(userRegistrationDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userRegistrationDTO.getPassword()));
        userService.createUser(user);
      }
    }
  }

  @RequestMapping(method = RequestMethod.PUT)
  public void updateUser(@RequestBody UserRegistrationDTO userRegistrationDTO) {
    User user = userService.getUser(userRegistrationDTO.getEmail());
    if (user != null) {
      if (userRegistrationDTO.getPassword() != null
          && userRegistrationDTO.getPassword().equals(userRegistrationDTO.getPasswordConfirmed())) {
        user.setPassword(passwordEncoder.encode(userRegistrationDTO.getPassword()));
        userService.updateUser(user);
      }
    }
  }

  @RequestMapping(method = RequestMethod.DELETE)
  public void deleteUser(@RequestParam String email) {
    userService.deleteUser(email);
  }
}
