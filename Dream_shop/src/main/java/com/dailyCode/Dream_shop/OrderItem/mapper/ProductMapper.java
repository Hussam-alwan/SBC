package com.dailyCode.Dream_shop.OrderItem.mapper;

import com.dailyCode.Dream_shop.OrderItem.Dto.ProductDto;
import com.dailyCode.Dream_shop.OrderItem.model.Product;
import com.dailyCode.Dream_shop.Product.Dto.ProductResponseDto;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {

    public ProductResponseDto toProductResponseDto(Product product) {

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

    public Product toProduct(ProductDto productDto) {

        Product product = new Product();
        product.setName(productDto.name());
        product.setBrand(productDto.brand());
        product.setPrice(productDto.price());
        product.setInventory(productDto.inventory());
        product.setDescription(productDto.description());
        product.setCategory(productDto.category());
        return product;
    }
}
