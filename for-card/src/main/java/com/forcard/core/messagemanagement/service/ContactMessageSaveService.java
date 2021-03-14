package com.forcard.core.messagemanagement.service;

import com.forcard.api.rest.request.ContactMessageRequest;
import com.forcard.api.rest.response.MessageResponse;
import com.forcard.core.messagemanagement.mapper.ContactMessageRequestMapper;
import com.forcard.core.messagemanagement.mapper.ContactMessageResponseMapper;
import com.forcard.core.messagemanagement.model.ContactMessage;
import com.forcard.core.messagemanagement.model.MessageStatus;
import com.forcard.core.messagemanagement.repository.ContactMessageRepository;
import com.forcard.core.shared.utils.time.TimeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ContactMessageSaveService {

    private static final String SUCCESSFUL_MESSAGE = "Message has been sent!";

    private final ContactMessageRepository contactMessageRepository;
    private final ContactMessageResponseMapper contactMessageResponseMapper;
    private final ContactMessageRequestMapper contactMessageRequestMapper;
    private final TimeService timeService;

    public ContactMessageSaveService(ContactMessageRepository contactMessageRepository,
                                     ContactMessageResponseMapper contactMessageResponseMapper,
                                     ContactMessageRequestMapper contactMessageRequestMapper,
                                     TimeService timeService) {
        this.contactMessageRepository = contactMessageRepository;
        this.contactMessageResponseMapper = contactMessageResponseMapper;
        this.contactMessageRequestMapper = contactMessageRequestMapper;
        this.timeService = timeService;
    }

    public ResponseEntity<?> createContactMessage(ContactMessageRequest request) {
        request.setCreateDate(timeService.getLocalDateTime());
        request.setStatus(MessageStatus.UNREAD.name());
        ContactMessage message = contactMessageRequestMapper.simplifyToDomainObject(request);
        contactMessageRepository.save(message);
        log.info("Contact message successfully created!");
        return ResponseEntity.ok().body(new MessageResponse(SUCCESSFUL_MESSAGE));
    }
}
