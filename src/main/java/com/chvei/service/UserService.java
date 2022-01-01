package com.chvei.service;

import com.chvei.domain.User;
import com.chvei.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.Optional;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUserByLogin(String login) {
        return userRepository.findUserByLogin(login)
                .orElse(null);
    }

    public Optional<User> getCurrentUser(Principal principal) {
        return userRepository.findUserByLogin(principal.getName());
    }
}
