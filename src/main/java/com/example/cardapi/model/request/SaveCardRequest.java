package com.example.cardapi.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveCardRequest {
    private String pan;
    private LocalDate expireDate;
    private String cvv;
    private String cardholder;
}
