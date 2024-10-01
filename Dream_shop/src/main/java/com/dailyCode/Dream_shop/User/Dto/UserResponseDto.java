package com.dailyCode.Dream_shop.User.Dto;

import com.dailyCode.Dream_shop.Cart.Dto.CartDto;
import com.dailyCode.Dream_shop.Order.Dto.OrderDto;

import java.util.List;

public record UserResponseDto(
        Long id,
        String firstName,
        String lastName,
        String email,
        List<OrderDto> orders,
        CartDto cart
) {}
