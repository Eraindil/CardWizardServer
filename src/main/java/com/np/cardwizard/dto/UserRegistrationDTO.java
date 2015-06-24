package com.np.cardwizard.dto;

public class UserRegistrationDTO {
  private String email;
  private String userName;
  private String password;
  private String passwordConfirmed;

  public UserRegistrationDTO() {
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPasswordConfirmed() {
    return passwordConfirmed;
  }

  public void setPasswordConfirmed(String passwordConfirmed) {
    this.passwordConfirmed = passwordConfirmed;
  }
}
