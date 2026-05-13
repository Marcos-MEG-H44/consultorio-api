package com.tuapp.consultorio.controller;

import com.tuapp.consultorio.dto.AuthResponse;
import com.tuapp.consultorio.dto.LoginRequest;
import com.tuapp.consultorio.dto.RegisterRequest;
import com.tuapp.consultorio.service.AuthService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    // REGISTER
    @PostMapping("/register")
    public AuthResponse register(
            @RequestBody RegisterRequest request
    ) {

        return authService.register(request);
    }

    // LOGIN
    @PostMapping("/login")
    public AuthResponse login(
            @RequestBody LoginRequest request
    ) {

        return authService.login(request);
    }
}