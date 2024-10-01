package com.dailyCode.Dream_shop.Product.mapper;

import com.dailyCode.Dream_shop.Product.Dto.ProductDto;
import com.dailyCode.Dream_shop.Product.Dto.ProductRequestDto;
import com.dailyCode.Dream_shop.Product.model.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {

    public ProductRequestDto toProductResponseDto(Product product) {

        return new ProductRequestDto(
                product.getName(),
                product.getBrand(),
                product.getPrice(),
                product.getInventory(),
                product.getDescription(),
                product.getCategory().getId()
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
