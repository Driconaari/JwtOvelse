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
        // Here, replace with actual logic to fetch user details from a database or other source
        if ("user".equals(username)) {
            return new User(
                    "user",
                    "{noop}password", // Use a password encoder in production
                    new ArrayList<>() // Add roles or authorities if needed
            );
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}

