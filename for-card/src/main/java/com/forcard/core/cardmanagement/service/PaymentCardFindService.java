package com.forcard.core.cardmanagement.service;

import com.forcard.api.rest.request.VerifyCardRequest;
import com.forcard.api.rest.response.PaymentCardResponse;
import com.forcard.api.rest.response.VerifyCardResponse;
import com.forcard.core.cardmanagement.mapper.PaymentCardResponseMapper;
import com.forcard.core.cardmanagement.model.PaymentCard;
import com.forcard.core.cardmanagement.repository.PaymentCardRepository;
import com.forcard.core.shared.exception.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static com.forcard.core.shared.utils.InfoUtils.NOT_FOUND;

@Service
@Slf4j
public class PaymentCardFindService {

    private final PaymentCardResponseMapper paymentCardResponseMapper;
    private final PaymentCardRepository paymentCardRepository;

    public PaymentCardFindService(PaymentCardResponseMapper paymentCardResponseMapper,
                                  PaymentCardRepository paymentCardRepository) {
        this.paymentCardResponseMapper = paymentCardResponseMapper;
        this.paymentCardRepository = paymentCardRepository;
    }

    public Collection<PaymentCardResponse> findAll() {
        List<PaymentCard> paymentCardList = paymentCardRepository.findAll();
        log.info("Found {} payment cards in the system.", paymentCardList.size());
        return paymentCardList.stream().map(paymentCardResponseMapper::simplifyToRestObject).collect(Collectors.toList());
    }

    public PaymentCardResponse findPaymentCardById(ObjectId id) {
        PaymentCard paymentCard = paymentCardRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(NOT_FOUND));
        log.info("PaymentCard with id: {} was found!", id);
        return paymentCardResponseMapper.simplifyToRestObject(paymentCard);
    }

    public Collection<PaymentCardResponse> findAllPaymentCardsByUserId(String userId) {
        Collection<PaymentCard> allPaymentCards = paymentCardRepository.findAllByUserId(userId);
        log.info("Find ({}) - payment cards for user with id: {}", allPaymentCards.size(), userId);
        return allPaymentCards.stream().map(paymentCardResponseMapper::simplifyToRestObject).collect(Collectors.toList());
    }

    public ResponseEntity<?> verifyPaymentCard(VerifyCardRequest verifyCardRequest) {
        PaymentCard paymentCard = paymentCardRepository.findById(new ObjectId(verifyCardRequest.getCardId()))
                .orElseThrow(() -> new EntityNotFoundException(NOT_FOUND));
        log.info("Payment card with id: {} was found!", verifyCardRequest.getCardId());
        VerifyCardResponse verifyPaymentCardResponse = new VerifyCardResponse();
        if (paymentCard.getCvvCode().equals(verifyCardRequest.getCvvCode())) {
            verifyPaymentCardResponse.setCardVerified(true);
            verifyPaymentCardResponse.setMessage("Payment card verified successfully!");
        } else {
            verifyPaymentCardResponse.setCardVerified(false);
            verifyPaymentCardResponse.setMessage("Payment card verification has failed!");
        }
        return ResponseEntity.ok(verifyPaymentCardResponse);
    }

}
