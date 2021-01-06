package com.forcard.api.endpoint;

import com.forcard.api.rest.request.LoginRequest;
import com.forcard.api.rest.request.SignupRequest;
import com.forcard.api.rest.response.JwtTokenResponse;
import com.forcard.api.rest.response.MessageResponse;
import com.forcard.core.usermanagement.service.TokenBlackListService;
import com.forcard.core.usermanagement.service.AuthService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private static final String LOGIN = "Login user with credentials.";
    private static final String LOGOUT = "Logout user from application.";
    private static final String REGISTER_NEW_USER = "Register new user.";
    private static final String CONFIRM_REGISTRATION = "Confirm new user registration";
    private static final String REFRESH_TOKEN = "Refresh token when it is expired.";

    private final AuthService authService;

    @Resource(name = "tokenBlackListService")
    private TokenBlackListService blackListService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signin")
    @ApiOperation(value = LOGIN, nickname = LOGIN)
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }

    @PostMapping("/signup")
    @ApiOperation(value = REGISTER_NEW_USER, nickname = REGISTER_NEW_USER)
    public ResponseEntity<?> registerNewUser(@Valid @RequestBody SignupRequest signupRequest, WebRequest webRequest) {
        return authService.register(signupRequest, webRequest);
    }

    @GetMapping("/refresh-token")
    @ApiOperation(value = REFRESH_TOKEN, nickname = REFRESH_TOKEN)
    public ResponseEntity<JwtTokenResponse> refreshToken(@RequestHeader(value = HttpHeaders.AUTHORIZATION) String bearerToken) {
        return authService.refreshToken(bearerToken);
    }

    @GetMapping("/registration-confirmation")
    @ApiOperation(value = CONFIRM_REGISTRATION, nickname = CONFIRM_REGISTRATION)
    public String confirmationRegistration(WebRequest request, @RequestParam("token") String token) {
        String response = authService.confirmRegistration(request, token);
        return ResponseEntity.ok(response).getBody();
    }

    @GetMapping("/logout")
    @ApiOperation(value = LOGOUT, nickname = LOGOUT)
    public ResponseEntity<?> logout(@RequestHeader(value = HttpHeaders.AUTHORIZATION) String bearerToken) {
        blackListService.addTokenToBlackListMap(bearerToken);
        return ResponseEntity.ok(new MessageResponse("Logout successfully!"));
    }

}
