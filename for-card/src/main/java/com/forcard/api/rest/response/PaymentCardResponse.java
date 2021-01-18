package com.forcard.api.rest.response;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class PaymentCardResponse {
    private String id;
    private String code;
    private String userId;
    private String paymentCardProvider;
    private String paymentCardHolder;
    private String paymentCardNumber;
    private LocalDate expiryDate;
    private String cvvCode;
    private boolean cardActive;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
}
