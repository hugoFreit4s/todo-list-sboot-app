package com.sharp.todo_list.service;

import com.sharp.todo_list.dto.CreateUserDto;
import com.sharp.todo_list.dto.LoginResponseDto;
import com.sharp.todo_list.dto.LoginUserDto;
import com.sharp.todo_list.dto.LogonResponseDto;
import com.sharp.todo_list.entity.User;
import com.sharp.todo_list.mapper.AuthMapper;
import com.sharp.todo_list.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public LogonResponseDto register(CreateUserDto requestDto) {
        final String rawPassword = requestDto.getPassword();
        User createdUser = userRepository.save(User
                .builder()
                .name(requestDto.getName())
                .email(requestDto.getEmail())
                .password(passwordEncoder.encode(requestDto.getPassword()))
                .createdAt(LocalDateTime.now())
                .build());

        LoginUserDto loginData = LoginUserDto
                .builder()
                .email(createdUser.getEmail())
                .password(rawPassword)
                .build();

        return AuthMapper.toResponse(createdUser, login(loginData));
    }

    public LoginResponseDto login(LoginUserDto requestDto) {
        User user = authenticate(requestDto);
        String jwtToken = jwtService.generateToken(user);
        return LoginResponseDto
                .builder()
                .token(jwtToken)
                .expiresIn(jwtService.getExpirationTime())
                .build();
    }

    public User authenticate(LoginUserDto requestDto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        requestDto.getEmail(),
                        requestDto.getPassword()
                )
        );

        return userRepository.findByEmail(requestDto.getEmail())
                .orElseThrow();
    }
}