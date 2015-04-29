package com.np.cardwizard.model.user;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

  @Id
  @Column(name = "email", nullable = false)
  private String email;

  @Basic
  @Column(name = "username", nullable = false, unique = true)
  private String userName;

  @Enumerated(EnumType.STRING)
  @Column(name = "role", nullable = false)
  private UserRole role;

  @Basic
  @Column(name = "password", nullable = false)
  private String password;

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

  public UserRole getRole() {
    return role;
  }

  public void setRole(UserRole role) {
    this.role = role;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
