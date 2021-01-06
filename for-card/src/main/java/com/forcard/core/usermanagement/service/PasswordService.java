package com.forcard.core.usermanagement.service;

import com.forcard.core.shared.utils.mail_service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Service
public class PasswordService {

    private final MailService mailService;
    private final TokenService tokenService;

    public PasswordService(MailService mailService,
                           TokenService tokenService) {
        this.mailService = mailService;
        this.tokenService = tokenService;
    }

    public ResponseEntity<String> resetUserPassword(HttpServletRequest request, String email) {
        return ResponseEntity.ok().build();
    }

}
