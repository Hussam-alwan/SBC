package com.dailyCode.Dream_shop.User.controller;

import com.dailyCode.Dream_shop.User.Dto.UserRequestDto;
import com.dailyCode.Dream_shop.User.Dto.UserResponseDto;
import com.dailyCode.Dream_shop.User.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.prefix}/users")
public class UserController {
    private final UserService userService;

    @GetMapping("/user/{userId}")
    public UserResponseDto getUserById(@PathVariable Long userId){
        return userService.findUserById(userId);
    }
    @PostMapping("/add")
    public UserResponseDto createUser(@RequestBody UserRequestDto userRequestDto){
        return this.userService.createUser(userRequestDto);
    }
    @PutMapping("/update/{userId}")
    public UserResponseDto updateUser(@RequestBody UserRequestDto userRequestDto,@PathVariable Long userId){
        return this.userService.UpdateUser(userRequestDto,userId);
    }

    @DeleteMapping("/delete/{userId}")
    public void deleteUser(@PathVariable Long userId){
        this.userService.deleteUser(userId);
    }

}