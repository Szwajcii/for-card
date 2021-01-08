package com.forcard.api.rest.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressResponse {
    private String street;
    private String number;
    private String flat;
    private String town;
    private String zipCode;
    private String country;
}
