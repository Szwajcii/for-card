package com.forcard.core.usermanagement.mapper;

import com.forcard.api.rest.request.UserRequest;
import com.forcard.api.rest.response.AddressResponse;
import com.forcard.api.rest.response.UserResponse;
import com.forcard.core.shared.model.Address;
import com.forcard.core.shared.utils.MapperService;
import com.forcard.core.usermanagement.model.User;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

@Component
public class UserResponseMapper implements MapperService<UserResponse, User> {


    @Override
    public UserResponse simplifyToRestObject(User domain) {
        UserResponse userResponse = new UserResponse();
        return mapFromDomainObject(domain, userResponse);
    }

    @Override
    public User simplifyToDomainObject(UserResponse rest) {
        User user = new User();
        return mapToDomainObject(user, rest);
    }

    public UserResponse mapFromRestToResponse(UserRequest request) {
        UserResponse response = new UserResponse();
        if (request.getId() != null) {
            response.setId(request.getId().toHexString());
        }
        response.setFirstName(request.getFirstName());
        response.setLastName(request.getLastName());
        response.setGender(request.getGender());
        response.setEmail(request.getEmail());
        response.setPhoneNumber(request.getPhoneNumber());
        if (request.getAddress() != null) {
            AddressResponse addressResponse = new AddressResponse(
                request.getAddress().getStreet(),
                request.getAddress().getNumber(),
                request.getAddress().getFlat(),
                request.getAddress().getTown(),
                request.getAddress().getZipCode(),
                request.getAddress().getCountry()
            );
            response.setAddress(addressResponse);
        }
        return response;
    }

    @Override
    public UserResponse mapFromDomainObject(User domain, UserResponse rest) {
        if (domain.getId() != null) {
            rest.setId(domain.getId().toHexString());
        }
        rest.setFirstName(domain.getFirstName());
        rest.setLastName(domain.getLastName());
        rest.setGender(domain.getGender().name());
        rest.setEmail(domain.getEmail());
        rest.setPhoneNumber(domain.getPhoneNumber());
        return rest;
    }

    @Override
    public User mapToDomainObject(User domain, UserResponse rest) {
        domain.setId(new ObjectId(rest.getId()));
        domain.setFirstName(rest.getFirstName());
        domain.setLastName(rest.getLastName());
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
