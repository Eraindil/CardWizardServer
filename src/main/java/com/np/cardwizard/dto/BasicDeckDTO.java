package com.np.cardwizard.dto;

import java.io.Serializable;
import java.util.List;

public class BasicDeckDTO implements Serializable {
  private String name;
  private List<BasicCardDTO> cards;

  public BasicDeckDTO() {
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
}
