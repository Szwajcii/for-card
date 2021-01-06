package com.forcard.core.usermanagement.service;

import com.forcard.api.rest.request.LoginRequest;
import com.forcard.api.rest.request.SignupRequest;
import com.forcard.api.rest.response.JwtTokenResponse;
import com.forcard.api.rest.response.MessageResponse;
import com.forcard.core.security.model.ForCardGrantedAuthority;
import com.forcard.core.security.model.LoggedUser;
import com.forcard.core.security.service.JwtUtils;
import com.forcard.core.security.service.LoggedUserProvider;
import com.forcard.core.shared.utils.time.TimeService;
import com.forcard.core.usermanagement.model.Gender;
import com.forcard.core.usermanagement.model.OnRegistrationCompleteEvent;
import com.forcard.core.usermanagement.model.User;
import com.forcard.core.usermanagement.model.VerificationToken;
import com.forcard.core.usermanagement.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.WebRequest;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;

@Slf4j
@Service("authService")
public class AuthService {

    @Resource(name = "tokenBlackListService")
    private TokenBlackListService blackListService;

    private final UserRepository userRepository;
    private final TokenService tokenService;
    private final MessageSource messageSource;
    private final TimeService timeService;
    private final ApplicationEventPublisher eventPublisher;
    private final LoggedUserProvider loggedUserProvider;

    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder encoder;
    private final JwtUtils jwtUtils;

    public AuthService(UserRepository userRepository,
                       TokenService tokenService,
                       MessageSource messageSource,
                       TimeService timeService,
                       ApplicationEventPublisher eventPublisher,
                       LoggedUserProvider loggedUserProvider,
                       AuthenticationManager authenticationManager,
                       PasswordEncoder encoder,
                       JwtUtils jwtUtils) {
        this.userRepository = userRepository;
        this.tokenService = tokenService;
        this.messageSource = messageSource;
        this.timeService = timeService;
        this.eventPublisher = eventPublisher;
        this.loggedUserProvider = loggedUserProvider;
        this.authenticationManager = authenticationManager;
        this.encoder = encoder;
        this.jwtUtils = jwtUtils;
    }

    @Scheduled(cron = "0 0/3 * * * *")
    public void clearBlacklist() {
        blackListService.performDeleteOldTokensFromBlackList();
    }

    public ResponseEntity<?> login(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        LoggedUser userDetails = (LoggedUser) authentication.getPrincipal();
        if (Boolean.FALSE.equals(userDetails.getEnabled())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Account is not active!"));
        }

        return ResponseEntity.ok(new JwtTokenResponse(jwt));
    }

    public ResponseEntity<?> register(SignupRequest signupRequest, WebRequest webRequest) {
        if (Boolean.TRUE.equals(userRepository.existsByEmail(signupRequest.getEmail()))) {
            return ResponseEntity.badRequest().body(new MessageResponse("Account with this email already exists!"));
        }
        User user = new User(
                signupRequest.getFirstName(),
                signupRequest.getLastName(),
                Gender.valueOf(signupRequest.getGender()),
                signupRequest.getEmail(),
                signupRequest.getPhoneNumber(),
                encoder.encode(signupRequest.getPassword())
        );

        user.setRoles(List.of(ForCardGrantedAuthority.of("USER")));
        user.setEnabled(false);
        userRepository.save(user);

        sendRegistrationNotification(user, webRequest);
        return ResponseEntity.ok(new MessageResponse("Registration Completed successfully!"));
    }

    private void sendRegistrationNotification(User user, WebRequest request) {
        OnRegistrationCompleteEvent onRegistrationCompleteEvent;
        try {
            String appUrl = request.getContextPath();
            onRegistrationCompleteEvent = new OnRegistrationCompleteEvent(appUrl, request.getLocale(), user);
            eventPublisher.publishEvent(onRegistrationCompleteEvent);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    public String confirmRegistration(WebRequest request, String token) {
        Locale locale = request.getLocale();
        VerificationToken verificationToken = tokenService.getVerificationToken(token);
        if (verificationToken == null) {
            return messageSource.getMessage("auth.message.clicked", null, locale);
        }
        User user = verificationToken.getUser();
        LocalDateTime clickedDateTime = timeService.getLocalDateTime();

        if (clickedDateTime.isAfter(verificationToken.getExpiryDate()) || clickedDateTime.isEqual(verificationToken.getExpiryDate())) {
            return messageSource.getMessage("auth.message.expired", null, locale);
        }
        user.setEnabled(true);
        userRepository.save(user);
        tokenService.removeToken(verificationToken);
        return messageSource.getMessage("auth.message.complete", null, locale);
    }

    public ResponseEntity<JwtTokenResponse> refreshToken(String bearerToken) {
        String token = jwtUtils.resolveToken(bearerToken).stream().findFirst().orElse(null);
        if (token == null || token.isEmpty()) {
            throw new AuthenticationServiceException("Invalid token!");
        }
        String newToken = jwtUtils.refreshToken(token);
        if (newToken == null) {
            // todo: Change response object
            return ResponseEntity.badRequest().body(new JwtTokenResponse("Cannot refresh token"));
        }
        log.info("Token refreshed for: {} - {}", loggedUserProvider.loggedUser().getEmail(), newToken);
        return ResponseEntity.ok(new JwtTokenResponse(newToken));
    }

}
