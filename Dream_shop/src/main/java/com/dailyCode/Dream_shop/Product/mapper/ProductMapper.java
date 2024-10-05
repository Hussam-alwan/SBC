package com.dailyCode.Dream_shop.Product.mapper;

import com.dailyCode.Dream_shop.Category.model.Category;
import com.dailyCode.Dream_shop.Category.repository.CategoryRepo;
import com.dailyCode.Dream_shop.Product.Dto.ProductDto;
import com.dailyCode.Dream_shop.Product.Dto.ProductResponseDto;
import com.dailyCode.Dream_shop.Product.model.Product;
import com.dailyCode.Dream_shop.exceptions.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {
    private final CategoryRepo categoryRepo;

    public ProductMapper(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public Product toProduct(ProductDto productDto){
        Category category= categoryRepo.findById(productDto.categoryId()).orElseThrow(() -> new EntityNotFoundException("Category not found"));
        Product product = new Product();
        product.setName(productDto.name());
        product.setBrand(productDto.brand());
        product.setPrice(productDto.price());
        product.setInventory(productDto.inventory());
        product.setDescription(productDto.description());
        product.setCategory(category);
        return product;
    }

    public ProductResponseDto toProductResponseDto(Product product){
        return new ProductResponseDto(
                product.getId(),
                product.getName(),
                product.getBrand(),
                product.getPrice(),
                product.getInventory(),
                product.getDescription(),
                product.getCategory().getId()
        );
    }

    public Product toProduct(ProductResponseDto productDto){
        Product product = new Product();
        product.setId(productDto.id());
        product.setName(productDto.name());
        product.setBrand(productDto.brand());
        product.setPrice(productDto.price());
        product.setInventory(productDto.inventory());
        product.setDescription(productDto.description());
        product.setCategory(categoryRepo.findById(productDto.categoryId()).orElseThrow(() -> new EntityNotFoundException("Category not found")));
        return product;
    }
}