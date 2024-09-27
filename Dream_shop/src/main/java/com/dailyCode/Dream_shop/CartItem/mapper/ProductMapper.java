package com.dailyCode.Dream_shop.CartItem.mapper;

import com.dailyCode.Dream_shop.CartItem.Dto.ProductDto;
import com.dailyCode.Dream_shop.CartItem.model.CartItem;
import com.dailyCode.Dream_shop.Product.Dto.ProductResponseDto;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {

    public ProductResponseDto toProductResponseDto(CartItem product) {

        return new ProductResponseDto(
                product.getId(),
                product.getName(),
                product.getBrand(),
                product.getPrice(),
                product.getInventory(),
                product.getDescription(),
                product.getCategory(),
                null
        );
     }

    public CartItem toProduct(ProductDto productDto) {

        CartItem product = new CartItem();
        product.setName(productDto.name());
        product.setBrand(productDto.brand());
        product.setPrice(productDto.price());
        product.setInventory(productDto.inventory());
        product.setDescription(productDto.description());
        product.setCategory(productDto.category());
        return product;
    }
}
