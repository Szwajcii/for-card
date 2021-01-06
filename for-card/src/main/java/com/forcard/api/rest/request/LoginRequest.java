package com.forcard.api.rest.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@AllArgsConstructor
public class LoginRequest {

    @Email
    @NotEmpty
    private String email;

    @NotEmpty
    private String password;
}
