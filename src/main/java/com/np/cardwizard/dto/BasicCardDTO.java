package com.np.cardwizard.dto;

public class BasicCardDTO {
  private String name;
  private int number;
  private int multiverseId;

  public BasicCardDTO() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public int getMultiverseId() {
    return multiverseId;
  }

  public void setMultiverseId(int multiverseId) {
    this.multiverseId = multiverseId;
  }
}
