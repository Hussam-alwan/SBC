package com.dailyCode.Dream_shop.Product.service;

import com.dailyCode.Dream_shop.Category.model.Category;
import com.dailyCode.Dream_shop.Category.repository.CategoryRepo;
import com.dailyCode.Dream_shop.Product.Dto.ProductDto;
import com.dailyCode.Dream_shop.Product.Dto.ProductResponseDto;
import com.dailyCode.Dream_shop.Product.mapper.ProductMapper;
import com.dailyCode.Dream_shop.Product.model.Product;
import com.dailyCode.Dream_shop.Product.repository.ProductRepo;
import com.dailyCode.Dream_shop.exceptions.EntityAlreadyExist;
import com.dailyCode.Dream_shop.exceptions.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductMapper productMapper;
    private final ProductRepo productRepo;
    private final CategoryRepo categoryRepo;

    public ProductResponseDto addProduct(ProductDto productRequestDto){
        Category category = categoryRepo.findById(productRequestDto.categoryId()).orElseThrow(() -> new EntityNotFoundException("Category not found"));
        if(productRepo.existsByNameAndBrandAndPrice(productRequestDto.name(),productRequestDto.brand(),productRequestDto.price())){
            throw new EntityAlreadyExist("Product already exists");
        }
        Product product= productMapper.toProduct(productRequestDto);
        product.setCategory(category);
        productRepo.save(product);
        return productMapper.toProductResponseDto(product);
    }

    public ProductResponseDto getProductById(Long id){
        Product product = productRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Product not found"));
        return productMapper.toProductResponseDto(product);
    }

            public void deleteProductById(Long id){
        Product product = productRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Product not found"));
        productRepo.delete(product);
    }

    public ProductResponseDto updateProduct(ProductDto productRequestDto, Long id){
        Product product = productRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Product not found"));
        product.setName(productRequestDto.name());
        product.setBrand(productRequestDto.brand());
        product.setPrice(productRequestDto.price());
        product.setInventory(productRequestDto.inventory());
        product.setDescription(productRequestDto.description());
        productRepo.save(product);
        return productMapper.toProductResponseDto(product);
    }

    public List<ProductResponseDto> getAllProduct(){
        return productRepo.findAll().stream().map(productMapper::toProductResponseDto).toList();
    }

    public List<ProductResponseDto> getAllProductByCategory(String name){
        return productRepo.findByCategoryName(name).stream().map(productMapper::toProductResponseDto).toList();
    }

    public List<ProductResponseDto> getAllProductByBrand(String brand){
        return productRepo.findByBrand(brand).stream().map(productMapper::toProductResponseDto).toList();
    }

    public List<ProductResponseDto> getAllProductByCategoryAndBrand(String category, String brand){
        return productRepo.findByCategoryNameAndBrand(category,brand).stream().map(productMapper::toProductResponseDto).toList();
    }

    public List<ProductResponseDto> getAllProductByName(String name){
        return productRepo.findByName(name).stream().map(productMapper::toProductResponseDto).toList();
    }

    public List<ProductResponseDto> getAllProductByBrandAndName(String brand,String name){
        return productRepo.findByBrandAndName(brand,name).stream().map(productMapper::toProductResponseDto).toList();
    }

    public long countProductByBrandAndName(String brand,String name){
        return productRepo.countByBrandAndName(brand,name);
    }
}
