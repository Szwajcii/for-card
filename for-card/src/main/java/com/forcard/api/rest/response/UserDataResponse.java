package com.forcard.api.rest.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserDataResponse {
    private String id;
    private String code;
    private String gender;
    private String name;
    private int cards;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private String country;
}
