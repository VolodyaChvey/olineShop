package com.chvei.service;

import com.chvei.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.Objects.nonNull;

@Service
@Transactional
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userService.getUserByLogin(login);
        if (nonNull(user)) {
            return org.springframework.security.core.userdetails.User
                    .builder()
                    .username(user.getLogin())
                    .password(user.getPassword())
                    .authorities(getAuthorities())
                    .build();

        } else {
            throw new UsernameNotFoundException(login + "not found");
        }
    }

    private List<GrantedAuthority> getAuthorities() {
        return AuthorityUtils.createAuthorityList("VALID_USER_ROLE");
    }
}
