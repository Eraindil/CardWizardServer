package com.np.cardwizard.dto;

import java.io.Serializable;
import java.util.List;

public class BasicDeckDTO implements Serializable {
  private int id;
  private String name;
  private List<BasicCardDTO> cards;
  private String userEmail;
  private String description;

  public BasicDeckDTO() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<BasicCardDTO> getCards() {
    return cards;
  }

  public void setCards(List<BasicCardDTO> cards) {
    this.cards = cards;
  }

  public String getUserEmail() {
    return userEmail;
  }

  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
