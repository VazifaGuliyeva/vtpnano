package com.example.vtpnano.mapper;

import com.example.vtpnano.dto.RegisterRequets;
import com.example.vtpnano.dto.UserDto;
import com.example.vtpnano.entity.User;
import com.example.vtpnano.security.MyUserDetails;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    List<UserDto> toUserDto(List<User> users);

    UserDto toUserDto(User user);

    User toUser(UserDto userDto);

    MyUserDetails toMyUserDetails(User user);
    User toUserFromRegisterRequest(RegisterRequets registerRequets);
}
