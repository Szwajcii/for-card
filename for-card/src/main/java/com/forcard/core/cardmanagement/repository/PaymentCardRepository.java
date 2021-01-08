package com.forcard.core.cardmanagement.repository;

import com.forcard.core.cardmanagement.model.PaymentCard;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Collection;
import java.util.Optional;

public interface PaymentCardRepository extends MongoRepository<PaymentCard, ObjectId> {

    Collection<PaymentCard> findAllByUserId(String userId);

    Optional<PaymentCard> findPaymentCardByUserIdAndCardActive(String userId, boolean isCardActive);

    Optional<Long> countByUserId(String userId);

}
