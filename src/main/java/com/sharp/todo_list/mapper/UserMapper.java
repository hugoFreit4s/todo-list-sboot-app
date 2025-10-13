package com.sharp.todo_list.mapper;

import com.sharp.todo_list.dto.UserResponseDto;
import com.sharp.todo_list.entity.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {

    public static UserResponseDto toResponse(User entity) {
        return UserResponseDto
                .builder()
                .name(entity.getName())
                .email(entity.getEmail())
                .build();
    }
}