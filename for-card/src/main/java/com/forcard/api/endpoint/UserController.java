package com.forcard.api.endpoint;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private static final String UPDATE_USER = "Update user profile.";
    private static final String UPDATE_USER_ADDRESS = "Update user address.";

}
