package com.forcard.api.rest.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ContactMessageResponse {
    private String id;
    private String userId;
    private String name;
    private String email;
    private String message;
    private LocalDateTime createDate;
    private String status;
}
