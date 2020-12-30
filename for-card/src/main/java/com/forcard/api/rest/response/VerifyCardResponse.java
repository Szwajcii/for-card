package com.forcard.api.rest.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VerifyCardResponse {
    private String message;
    private boolean isCardVerified;
}
