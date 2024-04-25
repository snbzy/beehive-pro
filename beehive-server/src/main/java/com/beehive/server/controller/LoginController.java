package com.beehive.server.controller;


import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
public class LoginController {


    private  final AuthenticationManager authenticationManager;


    @PostMapping("/login")
    public String doLogin(@RequestBody User user) {
        UsernamePasswordAuthenticationToken unauthenticated = UsernamePasswordAuthenticationToken.unauthenticated(user.getUsername(), user.getPassword());
        try {
            Authentication authenticate = authenticationManager.authenticate(unauthenticated);
            SecurityContextHolder.getContext().setAuthentication(authenticate);
            return "success";
        } catch (AuthenticationException e) {
            return "error:" + e.getMessage();
        }
    }

    @GetMapping("/log")
    public String log(){
        return "log";
    }


}
