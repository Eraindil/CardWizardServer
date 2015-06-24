package com.np.cardwizard.model.deck;

import com.np.cardwizard.model.card.AssociatedCard;
import com.np.cardwizard.model.user.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "deck")
public abstract class AbstractDeck implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Basic
  @Column(name = "id", nullable = false)
  private Integer id;

  @Basic
  @Column(name = "name", nullable = false)
  private String name;

  @Basic
  @Column(name = "description", nullable = true)
  private String description;

  @OneToMany(mappedBy = "deck")
  private List<AssociatedCard> associatedCards;

  @ManyToOne
  @JoinColumn(name = "email", referencedColumnName = "email", nullable = false)
  private User user;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<AssociatedCard> getAssociatedCards() {
    return associatedCards;
  }

  public void setAssociatedCards(List<AssociatedCard> associatedCards) {
    this.associatedCards = associatedCards;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}
