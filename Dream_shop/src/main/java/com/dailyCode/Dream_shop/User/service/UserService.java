package com.dailyCode.Dream_shop.User.service;

import com.dailyCode.Dream_shop.User.Dto.UserRequestDto;
import com.dailyCode.Dream_shop.User.Dto.UserResponseDto;
import com.dailyCode.Dream_shop.User.mapper.UserMapper;
import com.dailyCode.Dream_shop.User.model.User;
import com.dailyCode.Dream_shop.User.repository.UserRepo;
import com.dailyCode.Dream_shop.exceptions.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserMapper userMapper;
    private final UserRepo userRepo;

    public UserResponseDto findUserById(Long id){
        User user= userRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));
        return userMapper.toUserDto(user);
    }

    public UserResponseDto findUserByEmail(String email){
        User user= userRepo.findByEmail(email);
        if(user ==null) throw new EntityNotFoundException("User Not Foun d");
        return userMapper.toUserDto(user);
    }
    public UserResponseDto createUser(UserRequestDto userRequestDto){
        if(userRepo.existsByEmail(userRequestDto.email())) throw new EntityNotFoundException("User Already Exists");
        User user= userMapper.toUser(userRequestDto);
        userRepo.save(user);
        return userMapper.toUserDto(user);
    }
    
}
