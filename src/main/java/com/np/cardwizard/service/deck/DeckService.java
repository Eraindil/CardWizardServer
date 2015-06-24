package com.np.cardwizard.service.deck;

import com.np.cardwizard.model.deck.AbstractDeck;

import java.util.List;

public interface DeckService {

  void createDeck(AbstractDeck deck);

  List<AbstractDeck> getDeckByUserEmail(String email);

  AbstractDeck getDeckById(int id);

  void updateDeck(AbstractDeck deck);

  void deleteDeck(int id);
}
