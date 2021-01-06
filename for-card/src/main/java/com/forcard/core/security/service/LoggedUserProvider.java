package com.forcard.core.security.service;

import com.forcard.core.security.model.LoggedUser;
import com.forcard.core.security.validation.LoggedUserNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Objects;

public class LoggedUserProvider {

    public LoggedUser loggedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (Objects.isNull(authentication) || !(authentication.getPrincipal() instanceof LoggedUser)) {
            throw new LoggedUserNotFoundException();
        }
        return (LoggedUser) authentication.getPrincipal();
    }

}
