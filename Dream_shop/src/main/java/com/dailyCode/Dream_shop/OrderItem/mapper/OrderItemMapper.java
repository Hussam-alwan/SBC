package com.dailyCode.Dream_shop.OrderItem.mapper;

import com.dailyCode.Dream_shop.OrderItem.Dto.OrderItemDto;
import com.dailyCode.Dream_shop.OrderItem.model.OrderItem;
import org.springframework.stereotype.Service;

@Service
public class OrderItemMapper {
    public OrderItemDto toOrderItemDto(OrderItem orderItem){
        return new OrderItemDto(
                orderItem.getId(),
                orderItem.getProduct().getName(),
                orderItem.getQuantity(),
                orderItem.getPrice()
        );
    }

    public OrderItem toOrderItem(OrderItemDto orderItemDto){
        OrderItem orderItem = new OrderItem();
        orderItem.setId(orderItemDto.productId());
        orderItem.setQuantity(orderItemDto.quantity());
        orderItem.setPrice(orderItemDto.price());
        return orderItem;
    }
}
