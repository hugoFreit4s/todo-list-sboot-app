package com.sharp.todo_list.enums;

import lombok.Getter;

@Getter
public enum UserRoleENUM {

    ADMIN(0),
    USER(1),
    GUEST(2);

    private int code;

    UserRoleENUM(int code) {
        this.code = code;
    }

    public static UserRoleENUM fromCode(int code) {
        for (UserRoleENUM role : UserRoleENUM.values()) {
            if (role.getCode() == code) {
                return role;
            }
        }
        throw new IllegalArgumentException("Código inválido: " + code);
    }
}