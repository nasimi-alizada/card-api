package com.example.cardapi.controller;

import com.example.cardapi.model.criteria.CardCriteria;
import com.example.cardapi.model.criteria.PageCriteria;
import com.example.cardapi.model.request.SaveCardRequest;
import com.example.cardapi.model.request.UpdateCardRequest;
import com.example.cardapi.model.response.CardResponse;
import com.example.cardapi.model.response.PageableCardResponse;
import com.example.cardapi.service.CardService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("v1/cards")
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;

    @GetMapping("/{id}")
    public CardResponse getCardById(@PathVariable Long id) {
        return cardService.getCardById(id);

    }

    @GetMapping
    public PageableCardResponse getCards(PageCriteria pageCriteria,
                                         CardCriteria cardCriteria) {
        return cardService.getCards(pageCriteria, cardCriteria);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public void saveCard(@RequestBody SaveCardRequest cardRequest) {
        cardService.saveCard(cardRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void updateCard(@PathVariable Long id,
                           @RequestBody UpdateCardRequest cardRequest) {
        cardService.updateCard(id, cardRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteCard(@PathVariable Long id) {
        cardService.deleteCard(id);
    }


}
