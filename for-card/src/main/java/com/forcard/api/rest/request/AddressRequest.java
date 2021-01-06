package com.forcard.api.rest.request;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AddressRequest {
    private String street;
    private String number;
    private String flat;
    private String town;
    private String zipCode;
    private String country;
}
