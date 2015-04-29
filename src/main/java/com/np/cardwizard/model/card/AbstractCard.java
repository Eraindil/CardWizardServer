package com.np.cardwizard.model.card;

import com.np.cardwizard.model.type.AbstractCardType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "card")
public abstract class AbstractCard implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "multiverseId", nullable = false)
  private Integer multiverseId;

  @OneToMany(mappedBy = "card")
  private List<AssociatedCard> associatedCards;

  @ManyToMany
  @JoinTable(name = "card_type_card",
      joinColumns = @JoinColumn(name = "multiverse_id", referencedColumnName = "multiverseId", nullable = false),
      inverseJoinColumns = @JoinColumn(name = "type_id", referencedColumnName = "id", nullable = false))
  private List<AbstractCardType> cardTypes;

  @Basic
  @Column(name = "name")
  private String name;

  @Basic
  @Column(name = "flavor")
  private String flavor;

  public Integer getMultiverseId() {
    return multiverseId;
  }

  public void setMultiverseId(Integer multiverseId) {
    this.multiverseId = multiverseId;
  }

  public List<AssociatedCard> getAssociatedCards() {
    return associatedCards;
  }

  public void setAssociatedCards(List<AssociatedCard> associatedCards) {
    this.associatedCards = associatedCards;
  }

  public List<AbstractCardType> getCardTypes() {
    return cardTypes;
  }

  public void setCardTypes(List<AbstractCardType> cardTypes) {
    this.cardTypes = cardTypes;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
