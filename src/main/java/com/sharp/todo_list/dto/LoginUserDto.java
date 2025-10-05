package com.sharp.todo_list.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LoginUserDto {

    private String email;
    private String password;
}
