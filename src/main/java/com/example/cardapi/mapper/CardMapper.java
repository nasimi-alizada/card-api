package com.example.cardapi.mapper;

import com.example.cardapi.dao.entity.CardEntity;
import com.example.cardapi.model.enums.CardStatus;
import com.example.cardapi.model.request.SaveCardRequest;
import com.example.cardapi.model.request.UpdateCardRequest;
import com.example.cardapi.model.response.CardResponse;
import com.example.cardapi.model.response.PageableCardResponse;
import org.springframework.data.domain.Page;

import java.util.stream.Collectors;

import static com.example.cardapi.model.enums.CardStatus.ACTIVE;

public class CardMapper {
    public static CardResponse buildCardResponse(CardEntity cardEntity) {
        return CardResponse.builder()
                .id(cardEntity.getId())
                .pan(cardEntity.getPan())
                .cvv(cardEntity.getCvv())
                .cardholder(cardEntity.getCardholder())
                .expireDate(cardEntity.getExpireDate())
                .build();
    }

    public static CardEntity buildCardEntity(SaveCardRequest cardRequest) {
        return CardEntity.builder()
                .status(ACTIVE)
                .cardholder(cardRequest.getCardholder())
                .pan(cardRequest.getPan())
                .expireDate(cardRequest.getExpireDate())
                .cvv(cardRequest.getCvv())
                .build();

    }

    public static void buildUpdateCardEntity(CardEntity cardEntity,
                                             UpdateCardRequest cardRequest) {
        cardEntity.setPan(cardRequest.getPan());
        cardEntity.setCvv(cardRequest.getCvv());
        cardEntity.setExpireDate(cardRequest.getExpireDate());


    }




}
