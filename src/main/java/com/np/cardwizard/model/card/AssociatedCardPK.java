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

  public AssociatedCardPK(int dackId, int multiverseId) {
    this.deckId = dackId;
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
