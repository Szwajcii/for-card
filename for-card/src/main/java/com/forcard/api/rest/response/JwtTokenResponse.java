package com.forcard.api.rest.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class JwtTokenResponse {
    private String jwtToken;
}
