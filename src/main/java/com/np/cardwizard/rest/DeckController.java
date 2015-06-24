package com.np.cardwizard.rest;

import com.np.cardwizard.dto.BasicDeckDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeckController {

  @RequestMapping(method = RequestMethod.POST)
  public void createDeck(@RequestBody BasicDeckDTO basicDeckDTO) {

  }
}
