package com.sharp.todo_list.converter;

import com.sharp.todo_list.enums.UserRoleENUM;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class UserRoleEnumConverter implements AttributeConverter<UserRoleENUM, Integer> {

    @Override
    public Integer convertToDatabaseColumn(UserRoleENUM role) {
        return role != null ? role.getCode() : null;
    }

    @Override
    public UserRoleENUM convertToEntityAttribute(Integer code) {
        return code != null ? UserRoleENUM.fromCode(code) : null;
    }
}