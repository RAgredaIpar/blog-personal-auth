package com.ragredaipar.blog.backend.service;

import com.ragredaipar.blog.backend.dto.AuthResponse;
import com.ragredaipar.blog.backend.dto.LoginRequest;
import com.ragredaipar.blog.backend.dto.RegisterRequest;
import com.ragredaipar.blog.backend.model.User;
import com.ragredaipar.blog.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthResponse register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("El correo electrónico ya está registrado.");
        }

        User user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();

        userRepository.save(user);

        String jwt = jwtService.generateToken(user.getEmail());
        return new AuthResponse(jwt);
    }

    public AuthResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("El correo no está registrado."));

        boolean passwordCorrecta = passwordEncoder.matches(
                request.getPassword(),
                user.getPassword()
        );

        if (!passwordCorrecta) {
            throw new IllegalArgumentException("La contraseña es incorrecta.");
        }

        String jwt = jwtService.generateToken(user.getEmail());
        return new AuthResponse(jwt);
    }
}
