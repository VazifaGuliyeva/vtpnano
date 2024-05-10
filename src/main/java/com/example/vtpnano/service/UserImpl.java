package com.example.vtpnano.service;

import com.example.vtpnano.config.PasswordConfig;
import com.example.vtpnano.dto.RegisterRequets;
import com.example.vtpnano.dto.UserDto;
import com.example.vtpnano.entity.User;
import com.example.vtpnano.errors.UserNotFoundException;
import com.example.vtpnano.mapper.UserMapper;
import com.example.vtpnano.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
@Component
@RequiredArgsConstructor
public class UserImpl implements UserService{

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;



    @Override
    public List<UserDto> getAll() {
        return userMapper.toUserDto(userRepository.findAll());
    }

    @Override
    public UserDto getById(UUID id) {
        return userMapper.toUserDto(userRepository.findById(id).get());
    }

    @Override
    public void createUser(UserDto userDto) {

        User user=userMapper.toUser(userDto);

        userRepository.save(user);

    }

    @Override
    public void updateUser(UUID id, UserDto userDto) {

        User existingUser=userRepository.findById(id).orElseThrow(()->new UserNotFoundException("User is not found"));

        existingUser.setId(userDto.getId());
        existingUser.setFullName(userDto.getFullName());
        existingUser.setEmail(userDto.getEmail());
        existingUser.setPassword(userDto.getPassword());

        userRepository.save(existingUser);

    }

    @Override
    public void deleteAllUsers() {
        userRepository.deleteAll();

    }

    @Override
    public void deleteUserById(UUID id) {

        userRepository.deleteById(id);

    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findUserByEmail(email).orElseThrow(()-> new UserNotFoundException("User is not found"));
    }

    @Override
    public void registerRequest(RegisterRequets registerRequets) {

        User user=userMapper.toUserFromRegisterRequest(registerRequets);
        user.setId(UUID.randomUUID());
        user.setPassword(passwordEncoder.encode(registerRequets.getPassword()));

        userRepository.save(user);
    }
}
