package com.np.cardwizard.model.user;

public enum UserRole {
  USER,
  ADMIN;

  public String toRoleString() {
    return "ROLE_" + this.toString();

  }
}
