package com.dailyCode.Dream_shop.Product.service;

import com.dailyCode.Dream_shop.Product.Dto.ProductDto;
import com.dailyCode.Dream_shop.Product.Dto.ProductResponseDto;
import com.dailyCode.Dream_shop.Product.mapper.ProductMapper;
import com.dailyCode.Dream_shop.Product.model.Product;
import com.dailyCode.Dream_shop.Product.repository.ProductRepo;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepo productRepo;
    private final ProductMapper productMapper;

    public ProductService(ProductRepo productRepo, ProductMapper productMapper) {
        this.productRepo = productRepo;
        this.productMapper = productMapper;
    }

    public ProductResponseDto getProductById(Long id){
        Product product= productRepo.findById(id).orElse(null);
        return null;
    }

    public void deleteProductById(Long id){
        productRepo.deleteById(id);
    }
    public ProductResponseDto updateProductById(Long id, ProductDto productDto){
        return null;
    }
}
