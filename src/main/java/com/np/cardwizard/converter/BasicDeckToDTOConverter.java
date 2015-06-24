package com.np.cardwizard.converter;

import com.np.cardwizard.dto.BasicDeckDTO;
import com.np.cardwizard.model.deck.BasicDeck;
import org.springframework.stereotype.Component;

@Component
public class BasicDeckToDTOConverter implements BaseDTOConverter<BasicDeck, BasicDeckDTO> {

  public BasicDeckDTO convertToDTO(BasicDeck basicDeck) {
    return null;
  }

  public BasicDeck convertFromDTO(BasicDeckDTO basicDeckDTO) {
    return null;
  }
}
