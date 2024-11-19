package com.jwtovelse.controller;

import com.jwtovelse.Utility.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;



@Controller
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(
            @RequestParam String username,
            @RequestParam String password,
            HttpServletResponse response
    ) {
        try {
            Authentication authenticate = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );
            String token = jwtUtil.generateToken(username);

            // Store the JWT token in an HTTP-only cookie
            Cookie cookie = new Cookie("jwtToken", token);
            cookie.setHttpOnly(true);
            cookie.setPath("/");
            cookie.setMaxAge(60 * 60); // 1 hour
            response.addCookie(cookie);

            return "redirect:/home";
        } catch (AuthenticationException e) {
            return "redirect:/login?error=true";
        }
    }

    @PostMapping("/logout")
    public String logout(HttpServletResponse response) {
        Cookie cookie = new Cookie("jwtToken", null);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge(0); // Delete the cookie
        response.addCookie(cookie);

        return "redirect:/login";
    }


}
