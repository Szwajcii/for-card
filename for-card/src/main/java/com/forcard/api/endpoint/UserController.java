package com.forcard.api.endpoint;

import com.forcard.api.rest.request.UserRequest;
import com.forcard.core.usermanagement.service.UserFindService;
import com.forcard.core.usermanagement.service.UserSaveService;
import io.swagger.annotations.ApiOperation;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private static final String FIND_ALL_USERS = "Find all users.";
    private static final String FIND_USER_BY_ID = "Find user by id.";
    private static final String UPDATE_USER = "Update user profile.";

    private final UserFindService userFindService;
    private final UserSaveService userSaveService;


    public UserController(UserFindService userFindService,
                          UserSaveService userSaveService) {
        this.userFindService = userFindService;
        this.userSaveService = userSaveService;
    }

    @GetMapping("/all")
    @ApiOperation(value = FIND_ALL_USERS, nickname = FIND_ALL_USERS)
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public Collection<?> findAllUsers() {
        return List.of();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = FIND_USER_BY_ID, nickname = FIND_USER_BY_ID)
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public ResponseEntity<?> findUserById(@PathVariable("id") String id) {
        return userFindService.findUserById(new ObjectId(id));
    }

    @PutMapping
    @ApiOperation(value = UPDATE_USER, nickname = UPDATE_USER)
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public ResponseEntity<?> updateUser(@RequestBody UserRequest request) {
        return userSaveService.updateUser(request);
    }

}
