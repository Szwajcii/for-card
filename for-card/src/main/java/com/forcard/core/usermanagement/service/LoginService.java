package com.forcard.core.usermanagement.service;

import com.forcard.core.security.model.LoggedUser;
import com.forcard.core.shared.exception.EntityNotFoundException;
import com.forcard.core.usermanagement.model.User;
import com.forcard.core.usermanagement.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static com.forcard.core.shared.utils.InfoUtils.NOT_FOUND;

@Service
public class LoginService implements UserDetailsService {

    private final UserRepository userRepository;

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new EntityNotFoundException(NOT_FOUND));
        return LoggedUser.build(user);
    }
}
