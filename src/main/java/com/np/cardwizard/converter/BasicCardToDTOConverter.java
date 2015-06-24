package com.np.cardwizard.converter;

import com.np.cardwizard.dto.BasicCardDTO;
import com.np.cardwizard.model.card.BasicCard;

public class BasicCardToDTOConverter implements BaseDTOConverter<BasicCard, BasicCardDTO> {
  @Override
  public BasicCardDTO convertToDTO(BasicCard associatedCard) {
    return null;
  }

  @Override
  public BasicCard convertFromDTO(BasicCardDTO basicCardDTO) {
    return null;
  }
}
