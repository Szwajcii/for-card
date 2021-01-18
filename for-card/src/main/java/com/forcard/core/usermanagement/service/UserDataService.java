package com.forcard.core.usermanagement.service;

import com.forcard.api.rest.response.UserDataResponse;
import com.forcard.core.cardmanagement.model.PaymentCard;
import com.forcard.core.cardmanagement.repository.PaymentCardRepository;
import com.forcard.core.usermanagement.mapper.UserDataMapper;
import com.forcard.core.usermanagement.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDataService {

    private final PaymentCardRepository paymentCardRepository;
    private final UserDataMapper userDataMapper;

    public UserDataService(PaymentCardRepository paymentCardRepository,
                           UserDataMapper userDataMapper) {
        this.paymentCardRepository = paymentCardRepository;
        this.userDataMapper = userDataMapper;
    }


    public UserDataResponse getUserData(User user) {
        List<PaymentCard> userPaymentCards = paymentCardRepository.findAllByUserId(user.getId().toHexString())
                .stream().collect(Collectors.toList());
        return userDataMapper.mapToUserDataObject(user, userPaymentCards.size());
    }

}
