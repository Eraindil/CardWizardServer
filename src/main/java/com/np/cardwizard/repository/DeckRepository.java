package com.np.cardwizard.repository;

import com.np.cardwizard.model.deck.AbstractDeck;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DeckRepository extends CrudRepository<AbstractDeck, Integer> {

  List<AbstractDeck> findByUserEmail(String email);
}
