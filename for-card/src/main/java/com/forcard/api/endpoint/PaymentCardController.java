package com.forcard.api.endpoint;

import com.forcard.core.cardmanagement.service.PaymentCardFindService;
import com.forcard.core.cardmanagement.service.PaymentCardSaveService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payment-card")
public class PaymentCardController {

    private static final String FIND_PAYMENT_CARD_BY_ID = "Find payment card by id";
    private static final String FIND_ALL_PAYMENT_CARDS_BY_USER_ID = "Find all payment cards by user id";
    private static final String ACTIVATE_PAYMENT_CARD = "Activate payment card";
    private static final String CREATE_PAYMENT_CARD = "Create payment card";
    private static final String UPDATE_PAYMENT_CARD = "Update payment card";
    private static final String DELETE_PAYMENT_CARD_BY_ID = "Delete payment card by id";
    private static final String VERIFY_PAYMENT_CARD_BY_CVV_CODE = "Verify payment card with cvv code";

    private final PaymentCardFindService paymentCardFindService;
    private final PaymentCardSaveService paymentCardSaveService;

    public PaymentCardController(PaymentCardFindService paymentCardFindService,
                                 PaymentCardSaveService paymentCardSaveService) {
        this.paymentCardFindService = paymentCardFindService;
        this.paymentCardSaveService = paymentCardSaveService;
    }
}
