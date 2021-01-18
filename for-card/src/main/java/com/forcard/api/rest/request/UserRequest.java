package com.forcard.api.rest.request;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;

@Getter
@Setter
public class UserRequest {
    private ObjectId id;
    private String code;
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private String phoneNumber;
    private AddressRequest address;
}
