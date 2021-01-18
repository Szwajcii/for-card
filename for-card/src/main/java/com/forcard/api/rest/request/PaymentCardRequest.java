package com.forcard.api.rest.request;

import lombok.Data;
import org.bson.types.ObjectId;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class PaymentCardRequest {
    private ObjectId id;
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
