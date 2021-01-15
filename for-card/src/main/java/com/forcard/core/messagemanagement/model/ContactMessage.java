package com.forcard.core.messagemanagement.model;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Getter
@Setter
@Document(collection = "contact-messages")
public class ContactMessage {

    private static final String ID = "_id";
    private static final String USER_ID = "userId";
    private static final String NAME = "name";
    private static final String EMAIL = "email";
    private static final String MESSAGE = "message";
    private static final String CREATE_DATE = "createDate";
    private static final String STATUS = "status";

    @Id
    @Field(ID)
    private ObjectId id;

    @Field(USER_ID)
    private String userId;

    @Field(NAME)
    private String name;

    @Field(EMAIL)
    private String email;

    @Field(MESSAGE)
    private String message;

    @Field(CREATE_DATE)
    private LocalDateTime createDate;

    @Field(STATUS)
    private MessageStatus status;
}
