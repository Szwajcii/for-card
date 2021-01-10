package com.forcard.api.endpoint;

import com.forcard.core.usermanagement.service.PasswordService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/password")
public class PasswordController {

    private static final String CHANGE_PASSWORD = "Change user password.";
    private static final String RESET_PASSWORD = "Reset user password.";
    private static final String SAVE_PASSWORD = "Save user password.";

    private final PasswordService passwordService;

    public PasswordController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }


    @PreAuthorize("hasAnyAuthority('USER')")
    @PostMapping("/reset-password")
    @ApiOperation(value = RESET_PASSWORD, nickname = RESET_PASSWORD)
    public ResponseEntity<String> resetPassword(HttpServletRequest request, @RequestParam("email") String email) {
        return passwordService.resetUserPassword(request, email);
    }


}
