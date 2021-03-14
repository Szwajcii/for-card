package com.forcard.core.messagemanagement.mapper;

import com.forcard.api.rest.response.ContactMessageResponse;
import com.forcard.core.messagemanagement.model.ContactMessage;
import com.forcard.core.messagemanagement.model.MessageStatus;
import com.forcard.core.shared.utils.MapperService;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

@Component
public class ContactMessageResponseMapper implements MapperService<ContactMessageResponse, ContactMessage> {

    @Override
    public ContactMessageResponse simplifyToRestObject(ContactMessage domain) {
        ContactMessageResponse rest = new ContactMessageResponse();
        return mapFromDomainObject(domain, rest);
    }

    @Override
    public ContactMessage simplifyToDomainObject(ContactMessageResponse rest) {
        ContactMessage domain = new ContactMessage();
        return mapToDomainObject(domain, rest);
    }

    @Override
    public ContactMessageResponse mapFromDomainObject(ContactMessage domain, ContactMessageResponse rest) {
        rest.setId(domain.getId().toHexString());
        rest.setUserId(domain.getUserId());
        rest.setName(domain.getName());
        rest.setEmail(domain.getEmail());
        rest.setMessage(domain.getMessage());
        rest.setCreateDate(domain.getCreateDate());
        rest.setStatus(domain.getStatus().name());
        return rest;
    }

    @Override
    public ContactMessage mapToDomainObject(ContactMessage domain, ContactMessageResponse rest) {
        domain.setId(new ObjectId(rest.getId()));
        domain.setUserId(rest.getUserId());
        domain.setName(rest.getName());
        domain.setEmail(rest.getEmail());
        domain.setMessage(rest.getMessage());
        domain.setCreateDate(rest.getCreateDate());
        domain.setStatus(MessageStatus.valueOf(rest.getStatus()));
        return domain;
    }
}
