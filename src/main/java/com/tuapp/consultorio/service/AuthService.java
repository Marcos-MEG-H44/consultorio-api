package com.tuapp.consultorio.service;

import com.tuapp.consultorio.dto.AuthResponse;
import com.tuapp.consultorio.dto.LoginRequest;
import com.tuapp.consultorio.dto.RegisterRequest;
import com.tuapp.consultorio.entity.User;
import com.tuapp.consultorio.repository.UserRepository;
import com.tuapp.consultorio.security.JwtService;

import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    // REGISTER
    public AuthResponse register(RegisterRequest request) {

        User user = User.builder()
                .username(request.getUsername())
                .password(
                        passwordEncoder.encode(request.getPassword())
                )
                .role("USER")
                .build();

        userRepository.save(user);

        String token = jwtService.generateToken(user.getUsername());

        return new AuthResponse(token);
    }

    // LOGIN
    public AuthResponse login(LoginRequest request) {

        User user = userRepository.findByUsername(
                request.getUsername()
        ).orElseThrow(() ->
                new RuntimeException("Usuario no encontrado")
        );

        boolean passwordOk = passwordEncoder.matches(
                request.getPassword(),
                user.getPassword()
        );

        if (!passwordOk) {

            throw new RuntimeException("Password incorrecta");
        }

        String token = jwtService.generateToken(user.getUsername());

        return new AuthResponse(token);
    }
}