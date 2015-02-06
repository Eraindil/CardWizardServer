package com.np.cardwizard.model;

public enum UserRole {
  USER,
  ADMIN;

  public String toRoleString() {
    return "ROLE_" + this.toString();

  }
}
