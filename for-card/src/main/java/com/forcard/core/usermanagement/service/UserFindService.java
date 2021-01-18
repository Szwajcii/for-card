package com.forcard.core.usermanagement.service;

import com.forcard.api.rest.response.UserDataResponse;
import com.forcard.api.rest.response.UserResponse;
import com.forcard.core.security.model.ForCardGrantedAuthority;
import com.forcard.core.security.model.UserRole;
import com.forcard.core.shared.exception.EntityNotFoundException;
import com.forcard.core.shared.exception.ErrorCode;
import com.forcard.core.usermanagement.mapper.UserResponseMapper;
import com.forcard.core.usermanagement.model.User;
import com.forcard.core.usermanagement.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserFindService {

    private final UserRepository userRepository;
    private final UserResponseMapper userResponseMapper;
    private final UserDataService userDataService;

    public UserFindService(UserRepository userRepository,
                           UserResponseMapper userResponseMapper,
                           UserDataService userDataService) {
        this.userRepository = userRepository;
        this.userResponseMapper = userResponseMapper;
        this.userDataService = userDataService;
    }

    public Collection<UserDataResponse> findAllUsers() {
        Collection<User> users = userRepository.findAll();
        Collection<User> filteredUsers = users.stream()
                .filter(user -> !user.getRoles().contains(ForCardGrantedAuthority.of(UserRole.ADMIN.name())))
                .collect(Collectors.toList());
        log.info("Found {} system users.", filteredUsers.size());
        return filteredUsers.stream().map(userDataService::getUserData).collect(Collectors.toList());
    }

    public ResponseEntity<?> findUserById(ObjectId id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(ErrorCode.ENTITY_NOT_FOUND.getDescription()));
        log.info("User with id: {} was found!", id.toHexString());
        UserResponse userResponse = userResponseMapper.simplifyToRestObject(user);
        return ResponseEntity.ok().body(userResponse);
    }
}
