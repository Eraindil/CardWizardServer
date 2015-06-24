package com.np.cardwizard.service.deck;

import com.np.cardwizard.model.deck.AbstractDeck;
import com.np.cardwizard.repository.DeckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DeckServiceImpl implements DeckService {

  @Autowired
  private DeckRepository deckRepository;


  @Override
  @Transactional
  public void createDeck(AbstractDeck deck) {
    deckRepository.save(deck);
  }

  @Override
  public List<AbstractDeck> getDeckByUserEmail(String email) {
    return deckRepository.findByUserEmail(email);
  }

  @Override
  public AbstractDeck getDeckById(int id) {
    return deckRepository.findOne(id);
  }

  @Override
  public void updateDeck(AbstractDeck deck) {
    deckRepository.save(deck);
  }

  @Override
  public void deleteDeck(int id) {
    deckRepository.delete(id);
  }
}
