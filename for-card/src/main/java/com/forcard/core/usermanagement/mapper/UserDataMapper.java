package com.forcard.core.usermanagement.mapper;

import com.forcard.api.rest.response.UserDataResponse;
import com.forcard.core.usermanagement.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserDataMapper {

    public UserDataResponse mapToUserDataObject(User user, int cards) {
        UserDataResponse userDataResponse = new UserDataResponse();
        userDataResponse.setId(user.getId().toHexString());
        userDataResponse.setCode(user.getCode());
        userDataResponse.setGender(user.getGender().name());
        userDataResponse.setName(generateFullName(user));
        userDataResponse.setCards(cards);
        userDataResponse.setCreatedAt(user.getCreatedAt());
        userDataResponse.setModifiedAt(user.getModifiedAt());
        if (user.getAddress() != null && user.getAddress().getCountry() != null) {
            userDataResponse.setCountry(user.getAddress().getCountry());
        }
        return userDataResponse;
    }

    private String generateFullName(User user) {
        StringBuilder fullName = new StringBuilder();
        if (user.getFirstName() != null) {
            fullName.append(user.getFirstName());
        }
        if (user.getLastName() != null) {
            fullName.append(" ");
            fullName.append(user.getLastName());
        }
        return fullName.toString().trim();
    }

}
