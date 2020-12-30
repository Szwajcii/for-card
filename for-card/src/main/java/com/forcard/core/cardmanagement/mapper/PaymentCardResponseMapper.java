package com.forcard.core.cardmanagement.mapper;

import com.forcard.api.rest.request.PaymentCardRequest;
import com.forcard.api.rest.response.PaymentCardResponse;
import com.forcard.core.cardmanagement.model.PaymentCard;
import com.forcard.core.shared.utils.MapperService;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

@Component
public class PaymentCardResponseMapper implements MapperService<PaymentCardResponse, PaymentCard> {

    @Override
    public PaymentCardResponse simplifyToRestObject(PaymentCard domain) {
        PaymentCardResponse rest = new PaymentCardResponse();
        return mapFromDomainObject(domain, rest);
    }

    @Override
    public PaymentCard simplifyToDomainObject(PaymentCardResponse rest) {
        PaymentCard domain = new PaymentCard();
        return mapToDomainObject(domain, rest);
    }

    public PaymentCardResponse mapFromRestToResponse(PaymentCardRequest request) {
        PaymentCardResponse response = new PaymentCardResponse();
        if (request.getId() != null) {
            response.setId(request.getId().toHexString());
        }
        response.setUserId(request.getUserId());
        response.setPaymentCardProvider(request.getPaymentCardProvider());
        response.setPaymentCardHolder(request.getPaymentCardHolder());
        response.setPaymentCardNumber(request.getPaymentCardNumber());
        response.setExpiryDate(request.getExpiryDate());
        response.setCvvCode(request.getCvvCode());
        response.setCardActive(request.isCardActive());
        response.setCreatedDate(request.getCreatedDate());
        response.setModifiedDate(request.getModifiedDate());
        return response;
    }

    @Override
    public PaymentCardResponse mapFromDomainObject(PaymentCard domain, PaymentCardResponse rest) {
        rest.setId(domain.getId().toHexString());
        rest.setUserId(domain.getUserId());
        rest.setPaymentCardProvider(domain.getPaymentCardProvider());
        rest.setPaymentCardHolder(domain.getPaymentCardHolder());
        rest.setPaymentCardNumber(domain.getPaymentCardNumber());
        rest.setExpiryDate(domain.getExpiryDate());
        rest.setCvvCode(domain.getCvvCode());
        rest.setCardActive(domain.isCardActive());
        rest.setCreatedDate(domain.getCreatedDate());
        rest.setModifiedDate(domain.getModifiedDate());
        return rest;
    }

    @Override
    public PaymentCard mapToDomainObject(PaymentCard domain, PaymentCardResponse rest) {
        domain.setId(new ObjectId(rest.getId()));
        domain.setUserId(rest.getUserId());
        domain.setPaymentCardProvider(rest.getPaymentCardProvider());
        domain.setPaymentCardHolder(rest.getPaymentCardHolder());
        domain.setPaymentCardNumber(rest.getPaymentCardNumber());
        domain.setExpiryDate(rest.getExpiryDate());
        domain.setCvvCode(rest.getCvvCode());
        domain.setCardActive(rest.isCardActive());
        domain.setCreatedDate(rest.getCreatedDate());
        domain.setModifiedDate(rest.getModifiedDate());
        return domain;
    }
}
