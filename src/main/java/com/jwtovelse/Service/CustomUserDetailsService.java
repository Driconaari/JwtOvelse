package com.jwtovelse.Service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Replace this logic with actual database query
        if ("user".equals(username)) {
            return new User(
                    "user",
                    "{noop}password", // Use password encoder for real apps
                    new ArrayList<>()
            );
        }
        throw new UsernameNotFoundException("User not found");
    }
}
