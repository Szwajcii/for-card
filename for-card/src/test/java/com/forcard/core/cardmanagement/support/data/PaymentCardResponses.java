package com.forcard.core.cardmanagement.support.data;

import com.forcard.api.rest.response.PaymentCardResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static com.forcard.utils.Builder.anObject;

public class PaymentCardResponses {

    public static final String PAYMENT_CARD_ID = "123456";
    public static final String PAYMENT_CARD_CODE = "";
    public static final String PAYMENT_CARD_USER_ID = "";
    public static final String PAYMENT_CARD_PROVIDER = "Visa";
    public static final String PAYMENT_CARD_HOLDER = "";
    public static final String PAYMENT_CARD_NUMBER = "";
    public static final String PAYMENT_CARD_CVV_CODE = "";

    public static final LocalDate PAYMENT_CARD_EXPIRY_DATE = null;
    public static final LocalDateTime PAYMENT_CARD_CREATED_DATE = null;
    public static final LocalDateTime PAYMENT_CARD_MODIFIED_DATE = null;

    public static PaymentCardResponse aPaymentCardResponse() {
        return anObject(PaymentCardResponse.class)
                .with(f -> f.setId(PAYMENT_CARD_ID))
                .with(f -> f.setCode(PAYMENT_CARD_CODE))
                .with(f -> f.setUserId(PAYMENT_CARD_USER_ID))
                .with(f -> f.setPaymentCardProvider(PAYMENT_CARD_PROVIDER))
                .with(f -> f.setPaymentCardHolder(PAYMENT_CARD_HOLDER))
                .with(f -> f.setPaymentCardNumber(PAYMENT_CARD_NUMBER))
                .with(f -> f.setExpiryDate(PAYMENT_CARD_EXPIRY_DATE))
                .with(f -> f.setCvvCode(PAYMENT_CARD_CVV_CODE))
                .with(f -> f.setCardActive(true))
                .with(f -> f.setCreatedDate(PAYMENT_CARD_CREATED_DATE))
                .with(f -> f.setModifiedDate(PAYMENT_CARD_MODIFIED_DATE))
                .build();
    }


}
