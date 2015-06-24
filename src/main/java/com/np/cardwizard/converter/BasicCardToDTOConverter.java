package com.np.cardwizard.converter;

import com.np.cardwizard.dto.BasicCardDTO;
import com.np.cardwizard.model.card.BasicCard;
import org.springframework.stereotype.Component;

@Component
public class BasicCardToDTOConverter implements BaseDTOConverter<BasicCard, BasicCardDTO> {
  @Override
  public BasicCardDTO convertToDTO(BasicCard basicCard) {
    BasicCardDTO basicCardDTO = new BasicCardDTO();
    basicCardDTO.setMultiverseId(basicCard.getMultiverseId());
    basicCardDTO.setName(basicCard.getName());
    return basicCardDTO;
  }

  @Override
  public BasicCard convertFromDTO(BasicCardDTO basicCardDTO) {
    BasicCard basicCard = new BasicCard();
    basicCard.setName(basicCardDTO.getName());
    basicCard.setMultiverseId(basicCardDTO.getMultiverseId());
    return basicCard;
  }
}
