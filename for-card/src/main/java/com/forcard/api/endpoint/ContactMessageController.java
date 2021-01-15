package com.forcard.api.endpoint;

import com.forcard.core.messagemanagement.service.ContactMessageFindService;
import com.forcard.core.messagemanagement.service.ContactMessageSaveService;
import io.swagger.annotations.ApiOperation;
import org.bson.types.ObjectId;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api/contact")
public class ContactMessageController {

    private static final String FIND_ALL_MESSAGES_BY_USER_ID = "Find all messages by user id";
    private static final String FIND_UNREAD_MESSAGES = "Find unread messages";
    private static final String FIND_ARCHIVED_MESSAGES = "Find archived messages";
    private static final String CREATE_CONTACT_MESSAGE = "Create contact message";
    private static final String CHANGE_MESSAGE_STATUS = "Change message status";
    private static final String SEND_RESPONSE_MESSAGE_TO_USER = "Send response message to user";

    private final ContactMessageFindService contactMessageFindService;
    private final ContactMessageSaveService contactMessageSaveService;

    public ContactMessageController(ContactMessageFindService contactMessageFindService,
                                    ContactMessageSaveService contactMessageSaveService) {
        this.contactMessageFindService = contactMessageFindService;
        this.contactMessageSaveService = contactMessageSaveService;
    }

    @GetMapping("/all/{id}")
    @ApiOperation(value = FIND_ALL_MESSAGES_BY_USER_ID, nickname = FIND_ALL_MESSAGES_BY_USER_ID)
    @PreAuthorize("hasAuthority('ADMIN')")
    public Collection<?> findAllMessagesByUserId(@PathVariable("id") String id) {
        return contactMessageFindService.findByUserId(new ObjectId(id));
    }

    @GetMapping("/all/unread")
    @ApiOperation(value = FIND_UNREAD_MESSAGES, nickname = FIND_UNREAD_MESSAGES)
    @PreAuthorize("hasAuthority('ADMIN')")
    public Collection<?> findAllUnreadMessages() {
        return contactMessageFindService.findUnreadMessages();
    }

    @GetMapping("/all/archived")
    @ApiOperation(value = FIND_ARCHIVED_MESSAGES, nickname = FIND_ARCHIVED_MESSAGES)
    @PreAuthorize("hasAuthority('ADMIN')")
    public Collection<?> findAllArchivedMessages() {
        return contactMessageFindService.findArchivedMessages();
    }

}
