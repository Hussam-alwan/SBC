package com.dailyCode.Dream_shop.Product.controller;

import com.dailyCode.Dream_shop.Product.service.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
}
