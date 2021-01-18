package com.forcard.core.usermanagement.mapper;

import com.forcard.api.rest.request.UserRequest;
import com.forcard.core.shared.model.Address;
import com.forcard.core.shared.utils.MapperService;
import com.forcard.core.usermanagement.model.Gender;
import com.forcard.core.usermanagement.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserRequestMapper implements MapperService<UserRequest, User> {
    @Override
    public UserRequest simplifyToRestObject(User domain) {
        UserRequest request = new UserRequest();
        return mapFromDomainObject(domain, request);
    }

    @Override
    public User simplifyToDomainObject(UserRequest rest) {
        User user = new User();
        return mapToDomainObject(user, rest);
    }

    @Override
    public UserRequest mapFromDomainObject(User domain, UserRequest rest) {
        rest.setId(domain.getId());
        rest.setCode(domain.getCode());
        rest.setFirstName(domain.getFirstName());
        rest.setLastName(domain.getLastName());
        rest.setGender(domain.getGender().name());
        rest.setEmail(domain.getEmail());
        rest.setPhoneNumber(domain.getPhoneNumber());
        return rest;
    }

    @Override
    public User mapToDomainObject(User domain, UserRequest rest) {
        if (rest.getId() != null) {
            domain.setId(rest.getId());
        }
        domain.setCode(rest.getCode());
        domain.setFirstName(rest.getFirstName());
        domain.setLastName(rest.getLastName());
        domain.setGender(Gender.valueOf(rest.getGender()));
        domain.setEmail(rest.getEmail());
        domain.setPhoneNumber(rest.getPhoneNumber());
        if (rest.getAddress() != null) {
            Address address = new Address(
                rest.getAddress().getStreet(),
                rest.getAddress().getNumber(),
                rest.getAddress().getFlat(),
                rest.getAddress().getTown(),
                rest.getAddress().getZipCode(),
                rest.getAddress().getCountry()
            );
            domain.setAddress(address);
        }
        return domain;
    }
}
