package com.forcard.api.rest.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VerifyCardRequest {
    private String cardId;
    private String cvvCode;
}
