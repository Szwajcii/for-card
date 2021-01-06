package com.forcard.core.security.model;

import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.security.core.GrantedAuthority;


public class ForCardGrantedAuthority implements GrantedAuthority {

    public static final String USER_ROLE = "userRole";

    @Field(USER_ROLE)
    private final UserRole userRole;

    public ForCardGrantedAuthority(UserRole userRole) {
        this.userRole = userRole;
    }

    @Override
    public String getAuthority() {
        return null;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    @Override
    public String toString() {
        return userRole.name();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ForCardGrantedAuthority that = (ForCardGrantedAuthority) o;
        return userRole == that.userRole;
    }

    @Override
    public int hashCode() {
        return userRole != null ? userRole.hashCode() : 0;
    }

    public static ForCardGrantedAuthority of(String userRole) {
        return new ForCardGrantedAuthority(UserRole.valueOf(userRole));
    }
}
