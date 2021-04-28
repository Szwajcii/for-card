package com.forcard.core.cardmanagement.support.data;

import com.forcard.api.rest.request.PaymentCardRequest;

import static com.forcard.utils.Builder.anObject;

public class PaymentCardRequests {

    public static PaymentCardRequest aPaymentCardRequest() {
        return anObject(PaymentCardRequest.class)
                .build();
    }

}
