package com.forcard.core.usermanagement.model;

import com.forcard.core.security.model.ForCardGrantedAuthority;
import com.forcard.core.shared.model.Address;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.List;


@Setter
@Getter
@NoArgsConstructor
@Document(collection = "users")
public class User {

    private static final String ID = "_id";
    private static final String CODE = "code";
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";
    private static final String ROLES = "roles";
    private static final String GENDER = "gender";
    private static final String EMAIL = "email";
    private static final String PHONE_NUMBER = "phoneNumber";
    private static final String PASSWORD = "password";
    private static final String CREATED_AT = "createdAt";
    private static final String MODIFIED_AT = "modifiedAt";
    private static final String ENABLED = "enabled";
    private static final String ADDRESS = "address";

    @Id
    @Field(ID)
    private ObjectId id;

    @Field(CODE)
    private String code;

    @Field(FIRST_NAME)
    private String firstName;

    @Field(LAST_NAME)
    private String lastName;

    @Field(ROLES)
    private List<ForCardGrantedAuthority> roles;

    @Field(GENDER)
    private Gender gender;

    @Field(EMAIL)
    private String email;

    @Field(PHONE_NUMBER)
    private String phoneNumber;

    @Field(PASSWORD)
    private String password;

    @Field(CREATED_AT)
    private LocalDateTime createdAt;

    @Field(MODIFIED_AT)
    private LocalDateTime modifiedAt;

    @Field(ENABLED)
    private boolean enabled;

    @Field(ADDRESS)
    private Address address;

    public User(String firstName, String lastName, Gender gender, String email, String phone, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.phoneNumber = phone;
        this.password = password;
    }

}
