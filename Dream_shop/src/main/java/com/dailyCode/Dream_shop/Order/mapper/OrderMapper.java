package com.dailyCode.Dream_shop.Order.mapper;

import com.dailyCode.Dream_shop.Order.Dto.OrderDto;
import com.dailyCode.Dream_shop.Order.model.Order;
import com.dailyCode.Dream_shop.enums.OrderStatus;
import org.springframework.stereotype.Service;

@Service
public class OrderMapper {
    public OrderDto toOrderDto(Order order) {
        return new OrderDto(
                order.getOrderId(),
                order.getUser().getId(),
                order.getOrderDate(),
                order.getTotalAmount(),
                order.getOrderStatus().toString(),
                null
        );
    }
    public Order toOrder(OrderDto orderDto) {
        Order order = new Order();
        order.setOrderId(orderDto.id());
        order.setOrderDate(orderDto.orderDate());
        order.setTotalAmount(orderDto.totalAmount());
        order.setOrderStatus(OrderStatus.valueOf(orderDto.status()));
        return order;
    }
}
