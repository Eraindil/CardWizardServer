package com.np.cardwizard.rest;

import com.np.cardwizard.converter.BasicDeckToDTOConverter;
import com.np.cardwizard.dto.BasicDeckDTO;
import com.np.cardwizard.model.deck.BasicDeck;
import com.np.cardwizard.model.user.User;
import com.np.cardwizard.service.deck.DeckService;
import com.np.cardwizard.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/deck")
@RestController
public class DeckController {

  @Autowired
  private UserService userService;

  @Autowired
  private DeckService deckService;

  @Autowired
  private BasicDeckToDTOConverter basicDeckToDTOConverter;

  @RequestMapping(method = RequestMethod.POST)
  public void createDeck(@RequestBody BasicDeckDTO basicDeckDTO) {
    User user = userService.getUser(basicDeckDTO.getUserEmail());
    BasicDeck basicDeck = basicDeckToDTOConverter.convertFromDTO(basicDeckDTO);
    basicDeck.setUser(user);
    deckService.createDeck(basicDeck);
  }

  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public List<BasicDeckDTO> getDecks(@RequestParam String email) {
    List<BasicDeckDTO> basicDeckDTOs = new ArrayList<>();
    deckService.getDeckByUserEmail(email).forEach(basicDeck -> basicDeckDTOs.add(basicDeckToDTOConverter.convertToDTO((BasicDeck) basicDeck)));
    return basicDeckDTOs;
  }

  @RequestMapping(method = RequestMethod.GET)
  public BasicDeckDTO getDeck(@RequestParam int id) {
    return basicDeckToDTOConverter.convertToDTO((BasicDeck) deckService.getDeckById(id));
  }

  @RequestMapping(method = RequestMethod.PUT)
  public void updateDeck(@RequestBody BasicDeckDTO basicDeckDTO) {
    User user = userService.getUser(basicDeckDTO.getUserEmail());
    BasicDeck basicDeck = basicDeckToDTOConverter.convertFromDTO(basicDeckDTO);
    basicDeck.setUser(user);
    deckService.updateDeck(basicDeck);
  }

  @RequestMapping(method = RequestMethod.DELETE)
  public void deleteDeck(@RequestParam int id) {
    deckService.deleteDeck(id);
  }
}
