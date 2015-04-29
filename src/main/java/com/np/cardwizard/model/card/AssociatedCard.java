package com.np.cardwizard.model.card;

import com.np.cardwizard.model.deck.AbstractDeck;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "deck_card")
public class AssociatedCard implements Serializable {
  private static final long serialVersionUID = 1L;

  @EmbeddedId
  private AssociatedCardPK id;

  @ManyToOne
  @MapsId("deckId")
  @JoinColumn(name = "deck_id", referencedColumnName = "id", nullable = false)
  private AbstractDeck deck;

  @ManyToOne
  @MapsId("cardId")
  @JoinColumn(name = "multiverse_id", referencedColumnName = "multiverseId", nullable = false)
  private AbstractCard card;

  @Basic(optional = false)
  @Column(name = "number", nullable = false)
  private int number;

  public AssociatedCard() {
  }

  public AssociatedCardPK getId() {
    return id;
  }

  public void setId(AssociatedCardPK id) {
    this.id = id;
  }

  public AbstractDeck getDeck() {
    return deck;
  }

  public void setDeck(AbstractDeck deck) {
    this.deck = deck;
  }

  public AbstractCard getCard() {
    return card;
  }

  public void setCard(AbstractCard card) {
    this.card = card;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }
}
