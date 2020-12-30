package com.forcard.core.cardmanagement.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "payment-cards")
public class PaymentCard extends AbstractCard {

    public static final String PAYMENT_CARD_PROVIDER = "paymentCardProvider";
    public static final String PAYMENT_CARD_HOLDER = "paymentCardHolder";
    public static final String PAYMENT_CARD_NUMBER = "paymentCardNumber";
    public static final String CVV_CODE = "cvvCode";
    public static final String CARD_ACTIVE = "cardActive";

    @Field(PAYMENT_CARD_PROVIDER)
    private String paymentCardProvider;

    @Field(PAYMENT_CARD_HOLDER)
    private String paymentCardHolder;

    @Field(PAYMENT_CARD_NUMBER)
    private String paymentCardNumber;

    @Field(CVV_CODE)
    private String cvvCode;

    @Field(CARD_ACTIVE)
    private boolean cardActive;

}
