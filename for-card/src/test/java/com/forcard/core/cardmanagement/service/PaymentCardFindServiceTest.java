package com.forcard.core.cardmanagement.service;

import com.forcard.api.rest.response.PaymentCardResponse;
import com.forcard.core.cardmanagement.mapper.PaymentCardResponseMapper;
import com.forcard.core.cardmanagement.model.PaymentCard;
import com.forcard.core.cardmanagement.repository.PaymentCardRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.forcard.core.cardmanagement.support.data.PaymentCardResponses.aPaymentCardResponse;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PaymentCardFindServiceTest {

    @Mock
    PaymentCardRepository paymentCardRepository;

    @Mock
    PaymentCardResponseMapper paymentCardResponseMapper;

    @InjectMocks
    PaymentCardFindService paymentCardFindService;

    @BeforeEach()
    void init() {
    }

    @Test
    void testFindAllPaymentCards() {
        // given
        PaymentCardResponse paymentCardResponse = aPaymentCardResponse();

//        when(paymentCardRepository.findAll())
//                .thenReturn(List.of(paymentCardResponse));
        // when
        List<PaymentCardResponse> allPaymentCards = new ArrayList<>(paymentCardFindService.findAll());

        // then
        verify(paymentCardFindService).findAll();
        assertThat(allPaymentCards).containsExactly(paymentCardResponse);
    }

    @Test
    void testFindPaymentCardById() {
        // given


        // when
        when(paymentCardRepository.findAll()).thenReturn(List.of());

        // then

    }

    @Test
    void testFindAllPaymentCardsByUserId() {

    }

    @Test
    void testVerifyPaymentCard() {

    }

}