package com.np.cardwizard.model.type;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "card_type")
public class CardType implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id")
  private int id;

  @Basic
  @Column(name = "name")
  private String name;

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
}
