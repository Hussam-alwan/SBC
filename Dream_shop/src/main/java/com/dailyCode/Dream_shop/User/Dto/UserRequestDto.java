package com.dailyCode.Dream_shop.User.Dto;

public record UserRequestDto(
        String firstName,
        String lastName,
        String email,
        String password
) {}