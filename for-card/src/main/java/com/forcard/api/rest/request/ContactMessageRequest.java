package com.forcard.api.rest.request;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;

@Getter
@Setter
public class ContactMessageRequest {
    private ObjectId id;
    private String userId;
    private String name;
    private String email;
    private String message;
    private LocalDateTime createDate;
    private String status;
}
