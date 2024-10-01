package com.dailyCode.Dream_shop.OrderItem.model;

import com.dailyCode.Dream_shop.Order.model.Order;
import com.dailyCode.Dream_shop.Product.model.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OrderItem {
    @Id
    @GeneratedValue
    private Long id;
    private int quantity;
    private BigDecimal price;

    @ManyToOne
    @JoinColumn
    private Product product;

    @ManyToOne
    @JoinColumn
    private Order order;

}
