package com.forcard.core.cardmanagement.model;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public abstract class AbstractCard {

    public static final String ID = "_id";
    public static final String USER_ID = "userId";
    public static final String EXPIRY_DATE = "expiryDate";
    public static final String CREATED_DATE = "createdDate";
    public static final String MODIFIED_DATE = "modifiedDate";

    @Id
    @Field(ID)
    private ObjectId id;

    @Field(USER_ID)
    private String userId;

    @Field(EXPIRY_DATE)
    private LocalDate expiryDate;

    @Field(CREATED_DATE)
    private LocalDateTime createdDate;

    @Field(MODIFIED_DATE)
    private LocalDateTime modifiedDate;

}
