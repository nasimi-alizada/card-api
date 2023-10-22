package com.example.cardapi.service;

import com.example.cardapi.dao.entity.CardEntity;
import com.example.cardapi.dao.repository.CardRepository;
import com.example.cardapi.mapper.CardMapper;
import com.example.cardapi.model.criteria.CardCriteria;
import com.example.cardapi.model.criteria.PageCriteria;
import com.example.cardapi.model.enums.CardStatus;
import com.example.cardapi.model.request.SaveCardRequest;
import com.example.cardapi.model.request.UpdateCardRequest;
import com.example.cardapi.model.response.CardResponse;
import com.example.cardapi.model.response.PageableCardResponse;
import com.example.cardapi.service.specification.CardSpecification;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.cardapi.mapper.CardMapper.*;
import static com.example.cardapi.model.enums.CardStatus.*;

@Service
@Slf4j
@RequiredArgsConstructor

public class CardService {
    private final CardRepository cardRepository;

    public void send() {
        System.out.println("We send email");
    }

    public CardResponse getCardById(Long id) {
        var card = fetchCardIfExist(id);
        return buildCardResponse(card);
    }

    public List<CardResponse> getAllCard() {
        return cardRepository.findAll().stream()
                .map(CardMapper::buildCardResponse)
                .collect(Collectors.toList());

    }

    public PageableCardResponse getCards(PageCriteria pageCriteria,
                                         CardCriteria cardCriteria) {
        var cardPage = cardRepository.findAll(
                new CardSpecification(cardCriteria),
                PageRequest.of(pageCriteria.getPage(), pageCriteria.getCount()));
        return mapToPageableResponse(cardPage);

    }

    public void saveCard(SaveCardRequest cardRequest) {
        cardRepository.save(buildCardEntity(cardRequest));
    }

    public void updateCard(Long id, UpdateCardRequest cardRequest) {
        var cardEntity = fetchCardIfExist(id);
        buildUpdateCardEntity(cardEntity, cardRequest);
        cardRepository.save(cardEntity);
    }

    public void deleteCard(Long id) {
        var card = fetchCardIfExist(id);
        card.setStatus(BLOCKED);
        cardRepository.save(card);
    }


    private CardEntity fetchCardIfExist(Long id) {
        return cardRepository.findById(id).orElseThrow(
                () -> new RuntimeException("CARD_NOT_FOUND")
        );

    }

    private PageableCardResponse mapToPageableResponse(Page<CardEntity> cardEntityPage) {
        return PageableCardResponse.builder()
                .cards(cardEntityPage.getContent().stream().map(CardMapper::buildCardResponse).collect(Collectors.toList()))
                .hasNextPage(cardEntityPage.hasNext())
                .totalElements(cardEntityPage.getTotalElements())
                .lastPageNumber(cardEntityPage.getTotalPages())
                .build();
    }
}
