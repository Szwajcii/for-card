package com.forcard.core.cardmanagement.mapper;

import com.forcard.api.rest.request.PaymentCardRequest;
import com.forcard.core.cardmanagement.model.PaymentCard;
import com.forcard.core.shared.utils.MapperService;
import org.springframework.stereotype.Component;

@Component
public class PaymentCardRequestMapper implements MapperService<PaymentCardRequest, PaymentCard> {

    @Override
    public PaymentCardRequest simplifyToRestObject(PaymentCard domain) {
        PaymentCardRequest rest = new PaymentCardRequest();
        return mapFromDomainObject(domain, rest);
    }

    @Override
    public PaymentCard simplifyToDomainObject(PaymentCardRequest rest) {
        PaymentCard domain = new PaymentCard();
        return mapToDomainObject(domain, rest);
    }

    @Override
    public PaymentCardRequest mapFromDomainObject(PaymentCard domain, PaymentCardRequest rest) {
        rest.setId(domain.getId());
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
    public PaymentCard mapToDomainObject(PaymentCard domain, PaymentCardRequest rest) {
        if (rest.getId() != null) {
            domain.setId(rest.getId());
        }
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
