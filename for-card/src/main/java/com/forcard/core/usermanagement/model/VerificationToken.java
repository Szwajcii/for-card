package com.forcard.core.usermanagement.model;

import lombok.Getter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Document(collection = "tokens")
@Getter
public class VerificationToken {

    private static final String ID = "_id";
    private static final String TOKEN = "token";
    private static final String USER = "user";
    private static final String EXPIRY_DATE = "expiryDate";

    @Id
    @Field(ID)
    private ObjectId id;

    @Field(TOKEN)
    private final String token;

    @Field(USER)
    private final User user;

    @Field(EXPIRY_DATE)
    private final LocalDateTime expiryDate;

    public VerificationToken(User user, String token, LocalDateTime expiryDate) {
        this.user = user;
        this.token = token;
        this.expiryDate = expiryDate;
    }

}
