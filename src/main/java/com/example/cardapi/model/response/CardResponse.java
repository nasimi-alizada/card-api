package com.example.cardapi.model.response;

import com.example.cardapi.model.enums.CardStatus;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import static jakarta.persistence.EnumType.STRING;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CardResponse {
    private Long id;
    private String pan;
    private String cvv;
    private String cardholder;
    private LocalDate expireDate;

}
