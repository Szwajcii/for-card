package com.forcard.core.messagemanagement.mapper;

import com.forcard.api.rest.response.ContactMessageResponse;
import com.forcard.core.messagemanagement.model.ContactMessage;
import com.forcard.core.shared.utils.MapperService;
import org.springframework.stereotype.Component;

@Component
public class ContactMessageResponseMapper implements MapperService<ContactMessageResponse, ContactMessage> {

    @Override
    public ContactMessageResponse simplifyToRestObject(ContactMessage domain) {
        return null;
    }

    @Override
    public ContactMessage simplifyToDomainObject(ContactMessageResponse rest) {
        return null;
    }

    @Override
    public ContactMessageResponse mapFromDomainObject(ContactMessage domain, ContactMessageResponse rest) {
        return null;
    }

    @Override
    public ContactMessage mapToDomainObject(ContactMessage domain, ContactMessageResponse rest) {
        return null;
    }
}
