package com.sharp.todo_list.mapper;

import com.sharp.todo_list.dto.LoginResponseDto;
import com.sharp.todo_list.dto.LogonResponseDto;
import com.sharp.todo_list.entity.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AuthMapper {

    public static LogonResponseDto toResponse(User user, LoginResponseDto loginData) {
        return LogonResponseDto
                .builder()
                .name(user.getName())
                .email(user.getEmail())
                .loginData(loginData)
                .build();
    }
}