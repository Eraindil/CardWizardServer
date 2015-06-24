package com.np.cardwizard.converter;

import com.np.cardwizard.dto.BasicCardDTO;
import com.np.cardwizard.dto.BasicDeckDTO;
import com.np.cardwizard.model.card.AssociatedCard;
import com.np.cardwizard.model.card.BasicCard;
import com.np.cardwizard.model.deck.BasicDeck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BasicDeckToDTOConverter implements BaseDTOConverter<BasicDeck, BasicDeckDTO> {

  @Autowired
  private BasicCardToDTOConverter basicCardToDTOConverter;

  public BasicDeckDTO convertToDTO(BasicDeck basicDeck) {
    BasicDeckDTO basicDeckDTO = new BasicDeckDTO();
    basicDeckDTO.setId(basicDeck.getId());
    basicDeckDTO.setName(basicDeck.getName());
    List<BasicCardDTO> basicCardDTOs = new ArrayList<>();
    basicDeck.getAssociatedCards().forEach(associatedCard -> {
      BasicCardDTO basicCardDTO = basicCardToDTOConverter.convertToDTO((BasicCard) associatedCard.getCard());
      basicCardDTO.setNumber(associatedCard.getNumber());
      basicCardDTOs.add(basicCardDTO);
    });
    basicDeckDTO.setCards(basicCardDTOs);
    return basicDeckDTO;
  }

  public BasicDeck convertFromDTO(BasicDeckDTO basicDeckDTO) {
    BasicDeck basicDeck = new BasicDeck();
    basicDeck.setId(basicDeckDTO.getId());
    basicDeck.setName(basicDeckDTO.getName());
    basicDeck.setDescription(basicDeckDTO.getDescription());
    List<AssociatedCard> associatedCards = new ArrayList<>();
    basicDeckDTO.getCards().forEach(basicCardDTO -> {
      AssociatedCard associatedCard = new AssociatedCard();
      associatedCard.setNumber(basicCardDTO.getNumber());
      associatedCard.setCard(basicCardToDTOConverter.convertFromDTO(basicCardDTO));
      associatedCard.setDeck(basicDeck);
      associatedCards.add(associatedCard);
    });
    return basicDeck;
  }
}
