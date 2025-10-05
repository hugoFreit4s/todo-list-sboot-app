package com.sharp.todo_list.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LogonResponseDto {

    private String name;
    private String email;
    private LoginResponseDto loginData;
}