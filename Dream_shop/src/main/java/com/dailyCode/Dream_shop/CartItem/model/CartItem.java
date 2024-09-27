package com.dailyCode.Dream_shop.CartItem.model;

import com.dailyCode.Dream_shop.Cart.model.Cart;
import com.dailyCode.Dream_shop.Product.model.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class CartItem {
    private String name;
    @Id
    @GeneratedValue
    private Long id;
    private int quantity;
    private BigDecimal unitPrice;
    private BigDecimal totalPrice;

    @ManyToOne
    @JoinColumn
    private Product product;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Cart cart;

    public void setTotalPrice(){
        this.totalPrice=this.unitPrice.multiply(new BigDecimal(quantity));
    }


}
