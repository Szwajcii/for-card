package com.forcard.core.messagemanagement.mapper;

import com.forcard.api.rest.request.ContactMessageRequest;
import com.forcard.core.messagemanagement.model.ContactMessage;
import com.forcard.core.shared.utils.MapperService;
import org.springframework.stereotype.Component;

@Component
public class ContactMessageRequestMapper implements MapperService<ContactMessageRequest, ContactMessage> {

    @Override
    public ContactMessageRequest simplifyToRestObject(ContactMessage domain) {
        return null;
    }

    @Override
    public ContactMessage simplifyToDomainObject(ContactMessageRequest rest) {
        return null;
    }

    @Override
    public ContactMessageRequest mapFromDomainObject(ContactMessage domain, ContactMessageRequest rest) {
        return null;
    }

    @Override
    public ContactMessage mapToDomainObject(ContactMessage domain, ContactMessageRequest rest) {
        return null;
    }
}
