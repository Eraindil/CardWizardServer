package com.np.cardwizard.converter;

public interface BaseDTOConverter<Model, DTO> {
  DTO convertToDTO(Model model);

  Model convertFromDTO(DTO dto);
}
