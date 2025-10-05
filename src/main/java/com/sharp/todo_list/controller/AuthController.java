package com.sharp.todo_list.controller;

import com.sharp.todo_list.dto.CreateUserDto;
import com.sharp.todo_list.dto.LoginResponseDto;
import com.sharp.todo_list.dto.LoginUserDto;
import com.sharp.todo_list.dto.LogonResponseDto;
import com.sharp.todo_list.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<LogonResponseDto> register(@RequestBody CreateUserDto requestDto) {
        return ResponseEntity.ok(authService.register(requestDto));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginUserDto requestDto) {
        return ResponseEntity.ok(authService.login(requestDto));
    }
}