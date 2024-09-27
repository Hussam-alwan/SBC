package com.dailyCode.Dream_shop.Order.Dto;

import com.dailyCode.Dream_shop.OrderItem.Dto.OrderItemDto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record OrderDto(
    Long id,
    Long UserId,
    LocalDate orderDate,
    BigDecimal totalAmount,
    String status,
    List<OrderItemDto> orderItems
) {
}
