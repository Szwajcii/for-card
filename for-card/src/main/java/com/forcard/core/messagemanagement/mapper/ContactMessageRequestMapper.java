package com.forcard.core.messagemanagement.mapper;

import com.forcard.api.rest.request.ContactMessageRequest;
import com.forcard.core.messagemanagement.model.ContactMessage;
import com.forcard.core.messagemanagement.model.MessageStatus;
import com.forcard.core.shared.utils.MapperService;
import org.springframework.stereotype.Component;

@Component
public class ContactMessageRequestMapper implements MapperService<ContactMessageRequest, ContactMessage> {

    @Override
    public ContactMessageRequest simplifyToRestObject(ContactMessage domain) {
        ContactMessageRequest request = new ContactMessageRequest();
        return mapFromDomainObject(domain, request);
    }

    @Override
    public ContactMessage simplifyToDomainObject(ContactMessageRequest rest) {
        ContactMessage domain = new ContactMessage();
        return mapToDomainObject(domain, rest);
    }

    @Override
    public ContactMessageRequest mapFromDomainObject(ContactMessage domain, ContactMessageRequest rest) {
        if (domain.getId() != null) {
            rest.setId(domain.getId());
        }
        rest.setUserId(domain.getUserId());
        rest.setName(domain.getName());
        rest.setEmail(domain.getEmail());
        rest.setMessage(domain.getMessage());
        rest.setCreateDate(domain.getCreateDate());
        rest.setStatus(domain.getStatus().name());
        return rest;
    }

    @Override
    public ContactMessage mapToDomainObject(ContactMessage domain, ContactMessageRequest rest) {
        if (rest.getId() != null) {
            domain.setId(rest.getId());
        }
        domain.setUserId(rest.getUserId());
        domain.setName(rest.getName());
        domain.setEmail(rest.getEmail());
        domain.setMessage(rest.getMessage());
        domain.setCreateDate(rest.getCreateDate());
        domain.setStatus(MessageStatus.valueOf(rest.getStatus()));
        return domain;
    }
}
