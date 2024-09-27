package com.dailyCode.Dream_shop.Order.service;

import com.dailyCode.Dream_shop.Order.Dto.ProductDto;
import com.dailyCode.Dream_shop.Order.mapper.ProductMapper;
import com.dailyCode.Dream_shop.Order.model.Product;
import com.dailyCode.Dream_shop.Order.repository.ProductRepo;
import com.dailyCode.Dream_shop.Product.Dto.ProductResponseDto;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepo productRepo;
    private final ProductMapper productMapper;

    public ProductResponseDto getProductById(Long id){
        Product product= productRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Product not found"));
        return productMapper.toProductResponseDto(product);
    }

    public void deleteProductById(Long id){
        if (productRepo.findById(id).isEmpty())
            throw new EntityNotFoundException("Product not found");
        productRepo.deleteById(id);
    }
    public ProductResponseDto updateProductById(Long id, ProductDto productDto){
        if (productRepo.findById(id).isEmpty()) {
            throw new EntityNotFoundException("Product not found");
        }
        Product product=productMapper.toProduct(productDto);
        product.setId(id);
        productRepo.save(product);
        return productMapper.toProductResponseDto(product);
    }
    
}
