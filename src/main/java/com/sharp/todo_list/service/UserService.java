package com.sharp.todo_list.service;

import com.sharp.todo_list.dto.UpdateUserDto;
import com.sharp.todo_list.dto.UserResponseDto;
import com.sharp.todo_list.entity.User;
import com.sharp.todo_list.mapper.UserMapper;
import com.sharp.todo_list.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationService authenticationService;

    public UserResponseDto update(UpdateUserDto requestDto, Integer id) {
        if (!Objects.equals(authenticationService.getAuthenticated().getId(), id)) return null;
        Optional<User> optUser = userRepository.findById(id);
        if (optUser.isEmpty()) return null;
        User user = optUser.get();

        if (requestDto.getName() != null) {
            user.setName(requestDto.getName());
        }
        if (requestDto.getEmail() != null) {
            user.setEmail(requestDto.getEmail());
        }
        if (requestDto.getPassword() != null) {
            user.setPassword(passwordEncoder.encode(requestDto.getPassword()));
        }

        return UserMapper.toResponse(userRepository.save(user));
    }
}