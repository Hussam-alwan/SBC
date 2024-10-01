package com.dailyCode.Dream_shop.Cart.controller;

import com.dailyCode.Dream_shop.Cart.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api")
public class CartController {
    private final CartService cartService;


}
