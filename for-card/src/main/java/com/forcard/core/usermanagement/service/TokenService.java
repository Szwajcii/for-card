package com.forcard.core.usermanagement.service;

import com.forcard.core.shared.utils.time.TimeService;
import com.forcard.core.usermanagement.model.User;
import com.forcard.core.usermanagement.model.VerificationToken;
import com.forcard.core.usermanagement.repository.VerificationTokenRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class TokenService {

    private final VerificationTokenRepository verificationTokenRepository;
    private final TimeService timeService;

    public TokenService(VerificationTokenRepository verificationTokenRepository,
                        TimeService timeService) {
        this.verificationTokenRepository = verificationTokenRepository;
        this.timeService = timeService;
    }

    public String createVerificationToken(User user) {
        String token = UUID.randomUUID().toString();
        VerificationToken myToken = new VerificationToken(user, token, timeService.getLocalDateTime().plusHours(24));
        verificationTokenRepository.save(myToken);
        return token;
    }

    VerificationToken getVerificationToken(String token) {
        return verificationTokenRepository.findByToken(token).orElse(null);
    }

    void removeToken(VerificationToken token) {
        if (token != null) {
            verificationTokenRepository.delete(token);
            log.info("Token was deleted");
            return;

        }
        log.info("Token don't exists");
    }

}
