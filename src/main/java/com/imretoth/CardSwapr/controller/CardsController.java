package com.imretoth.CardSwapr.controller;

import com.imretoth.CardSwapr.data.Card;
import com.imretoth.CardSwapr.repositories.CardRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/cards")
public class CardsController {
    private final CardRepository cardRepository;

    public CardsController(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @GetMapping
    public List<Card> getCards() {
        return cardRepository.findAll();

    }

    @GetMapping("/{id}")
    public Card getCard(@PathVariable Long id) {
        return cardRepository.findById( id ).orElseThrow( RuntimeException::new );
    }

    @PostMapping
    public ResponseEntity createCard(@RequestBody Card card) throws URISyntaxException {
        Card savedCard = cardRepository.save( card );
        return ResponseEntity.created( new URI( "/cards/" + savedCard.getId() ) ).body( savedCard );
    }

    @PutMapping("/{id}")
    public ResponseEntity updateCard(@PathVariable("id") Long id, @RequestBody Card card) {
        Optional<Card> cardData = cardRepository.findById( id );
        if(cardData.isPresent()) {
            Card currentCard = cardData.get();
            currentCard.setName( card.getName() );
            currentCard.setPower( card.getPower() );

            return new ResponseEntity<>(cardRepository.save(currentCard), HttpStatus.OK);
        } else {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND );
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCard(@PathVariable Long id) {
        cardRepository.deleteById( id );
        return ResponseEntity.ok().build();
    }
}

