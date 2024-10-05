package com.dailyCode.Dream_shop.User.mapper;

import com.dailyCode.Dream_shop.User.Dto.UserRequestDto;
import com.dailyCode.Dream_shop.User.Dto.UserResponseDto;
import com.dailyCode.Dream_shop.User.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {
    public UserResponseDto toUserResponseDto(User user){
        return new UserResponseDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                null,
                null
        );
    }

    public User toUser(UserRequestDto userRequestDto){
        User user= new User();
        user.setFirstName(userRequestDto.firstName());
        user.setLastName(userRequestDto.lastName());
        user.setEmail(userRequestDto.email());
        user.setPassword(userRequestDto.password());
        return user;
    }
}
