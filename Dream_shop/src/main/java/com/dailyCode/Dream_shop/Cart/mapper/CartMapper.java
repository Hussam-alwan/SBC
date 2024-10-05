//package com.dailyCode.Dream_shop.Cart.mapper;
//
//import com.dailyCode.Dream_shop.Cart.Dto.CartDto;
//import com.dailyCode.Dream_shop.Cart.model.Cart;
//import com.dailyCode.Dream_shop.CartItem.mapper.CartItemMapper;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CartMapper {
//    private final CartItemMapper cartItemMapper;
//
//    public CartMapper(CartItemMapper cartItemMapper) {
//        this.cartItemMapper = cartItemMapper;
//    }
//
//    public CartDto toCartDto(Cart cart) {
//        return new CartDto(
//                cart.getItem(),
//                cart.getTotalAmount()
//        );
//    }
//
//}
