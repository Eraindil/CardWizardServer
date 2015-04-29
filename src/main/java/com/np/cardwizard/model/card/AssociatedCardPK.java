package com.np.cardwizard.model.card;

import javax.persistence.Basic;
import java.io.Serializable;

public class AssociatedCardPK implements Serializable {
  private static final long serialVersionUID = 1L;

  @Basic(optional = false)
  private int deckId;

  @Basic(optional = false)
  private int multiverseId;

  public AssociatedCardPK() {
  }

  public AssociatedCardPK(int deckId, int multiverseId) {
    this.deckId = deckId;
    this.multiverseId = multiverseId;
  }

  public int getDeckId() {
    return deckId;
  }

  public void setDeckId(int deckId) {
    this.deckId = deckId;
  }

  public int getMultiverseId() {
    return multiverseId;
  }

  public void setMultiverseId(int multiverseId) {
    this.multiverseId = multiverseId;
  }
}
