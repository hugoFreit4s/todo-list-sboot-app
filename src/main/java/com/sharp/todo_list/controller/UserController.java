package com.sharp.todo_list.controller;

import com.sharp.todo_list.dto.UpdateUserDto;
import com.sharp.todo_list.dto.UserResponseDto;
import com.sharp.todo_list.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PutMapping("/update/{id}")
    public ResponseEntity<UserResponseDto> update(@RequestBody UpdateUserDto requestDto, @PathVariable Integer id) {
        return ResponseEntity.ok(userService.update(requestDto, id));
    }
}