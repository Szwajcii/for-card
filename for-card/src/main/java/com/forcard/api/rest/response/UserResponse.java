package com.forcard.api.rest.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {
    private String id;
    private String code;
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private String phoneNumber;
    private AddressResponse address;
}
