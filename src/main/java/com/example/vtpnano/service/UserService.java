package com.example.vtpnano.service;

import com.example.vtpnano.dto.RegisterRequets;
import com.example.vtpnano.dto.UserDto;
import com.example.vtpnano.entity.User;

import java.util.List;
import java.util.UUID;

public interface UserService {

    List<UserDto> getAll();

    UserDto getById(UUID id);

    void createUser(UserDto userDto);

    void updateUser(UUID id,UserDto userDto);

    void deleteAllUsers();

    void deleteUserById(UUID id);

    User getUserByEmail(String email);

    void registerRequest(RegisterRequets registerRequets);
}
