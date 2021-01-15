package com.forcard.core.messagemanagement.service;

import com.forcard.core.messagemanagement.mapper.ContactMessageResponseMapper;
import com.forcard.core.messagemanagement.model.ContactMessage;
import com.forcard.core.messagemanagement.model.MessageStatus;
import com.forcard.core.messagemanagement.repository.ContactMessageRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Slf4j
@Service
public class ContactMessageFindService {

    private final ContactMessageRepository contactMessageRepository;
    private final ContactMessageResponseMapper contactMessageResponseMapper;

    public ContactMessageFindService(ContactMessageRepository contactMessageRepository,
                                     ContactMessageResponseMapper contactMessageResponseMapper) {
        this.contactMessageRepository = contactMessageRepository;
        this.contactMessageResponseMapper = contactMessageResponseMapper;
    }

    public Collection<?> findByUserId(ObjectId userId) {
        Collection<ContactMessage> contactMessages = contactMessageRepository.findByUserId(userId);
        log.info("Found {} for user with id: {}", contactMessages.size(), userId.toHexString());
        return List.of();
    }

    public Collection<?> findUnreadMessages() {
        return findMessagesByStatus(MessageStatus.UNREAD.name());
    }

    public Collection<?> findArchivedMessages() {
        return findMessagesByStatus(MessageStatus.ARCHIVED.name());
    }

    private Collection<?> findMessagesByStatus(String status) {
        Collection<ContactMessage> contactMessages = contactMessageRepository.findAllByStatus(status);
        log.info("Found {} {} messages", contactMessages.size(), status);
        return List.of();
    }

}
