package com.forcard.core.messagemanagement.service;

import com.forcard.core.messagemanagement.mapper.ContactMessageResponseMapper;
import com.forcard.core.messagemanagement.repository.ContactMessageRepository;
import com.forcard.core.shared.utils.time.TimeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ContactMessageSaveService {

    private final ContactMessageRepository contactMessageRepository;
    private final ContactMessageResponseMapper contactMessageResponseMapper;
    private final TimeService timeService;

    public ContactMessageSaveService(ContactMessageRepository contactMessageRepository,
                                     ContactMessageResponseMapper contactMessageResponseMapper,
                                     TimeService timeService) {
        this.contactMessageRepository = contactMessageRepository;
        this.contactMessageResponseMapper = contactMessageResponseMapper;
        this.timeService = timeService;
    }
}
