package com.example.springsecurityrolepermission.controller;


import com.example.springsecurityrolepermission.dto.LoginDTO;
import com.example.springsecurityrolepermission.entity.User;
import com.example.springsecurityrolepermission.service.AuthService;
import com.example.springsecurityrolepermission.service.RegisterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth/")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    AuthService authService;

    @PostMapping("login")
    public HttpEntity<?> login(@RequestBody LoginDTO dto) {

        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.getUserName(), dto.getPassword()));

        System.out.println(authenticate.getAuthorities());
        System.out.println(authenticate.getPrincipal());

        User principal = (User) authenticate.getPrincipal();
        return ResponseEntity.ok().body("Tizimga xush kelibsiz!  = > " + principal.getFullName());
    }

    @PostMapping("/register")
    public HttpEntity<?> register(@RequestBody RegisterDTO dto) {
        String register = authService.register(dto);
        return ResponseEntity.ok().body(register);
    }
}
