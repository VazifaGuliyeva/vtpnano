package com.example.vtpnano.controller;

import com.example.vtpnano.dto.RegisterRequets;
import com.example.vtpnano.dto.UserDto;
import com.example.vtpnano.entity.User;
import com.example.vtpnano.service.UserImpl;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {

    private final UserImpl userImpl;
    @GetMapping
    public List<UserDto> getAll() {
        return userImpl.getAll();
    }
    @GetMapping("/{id}")
    public UserDto getById(@PathVariable UUID id) {
        return userImpl.getById(id);
    }
    @PostMapping
    public void createUser(@RequestBody UserDto userDto) {

        userImpl.createUser(userDto);

    }
    @PutMapping("/{id}")
    public void updateUser(@PathVariable UUID id, @RequestBody UserDto userDto) {

        userImpl.updateUser(id,userDto);


    }
    @DeleteMapping
    public void deleteAllUsers() {
        userImpl.deleteAllUsers();
    }
    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable UUID id) {

        userImpl.deleteUserById(id);

    }
    @PostMapping("/register")
    public void register(@RequestBody RegisterRequets registerRequets){
        userImpl.registerRequest(registerRequets);

    }

    @PostMapping("/login")
    public String login(@RequestBody RegisterRequets request) {
        return userImpl.login(request);
    }
}
