package com.forcard.core.usermanagement.mapper;

import com.forcard.api.rest.request.UserRequest;
import com.forcard.core.shared.utils.MapperService;
import com.forcard.core.usermanagement.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserRequestMapper implements MapperService<UserRequest, User> {
    @Override
    public UserRequest simplifyToRestObject(User domain) {
        return null;
    }

    @Override
    public User simplifyToDomainObject(UserRequest rest) {
        return null;
    }

    @Override
    public UserRequest mapFromDomainObject(User domain, UserRequest rest) {
        return null;
    }

    @Override
    public User mapToDomainObject(User domain, UserRequest rest) {
        return null;
    }
}
