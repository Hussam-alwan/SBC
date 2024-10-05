package com.dailyCode.Dream_shop.Product.controller;

import com.dailyCode.Dream_shop.Product.Dto.ProductDto;
import com.dailyCode.Dream_shop.Product.Dto.ProductResponseDto;
import com.dailyCode.Dream_shop.Product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.NO_CONTENT;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.prefix}/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping("/all")
    public Iterable<ProductResponseDto> getAllProducts() {
        return this.productService.getAllProduct();
    }

    @GetMapping("product/{productId}")
    public ProductResponseDto getProductById(@PathVariable Long productId) {
        return this.productService.getProductById(productId);
    }

    @GetMapping("/products/by-brand")
    public List<ProductResponseDto> findProductByBrand(@RequestParam String brand){
        return this.productService.getAllProductByBrand(brand);
    }

    @GetMapping("/products/{categoryId}/all")
    public List<ProductResponseDto> findByCategory(@PathVariable String categoryId){
        return this.productService.getAllProductByCategory(categoryId);
    }
    @GetMapping("/products/{name}/")
    public List<ProductResponseDto> findProductByName(@PathVariable String name){
        return this.productService.getAllProductByName(name);
    }

    @GetMapping("/products/count/by-brand/by-name")
    public List<ProductResponseDto> findByBrandAndName(@RequestParam String brand,@RequestParam String name){
        return this.productService.getAllProductByBrandAndName(brand,name);
    }

    @GetMapping("/products/by-category/by-brand")
    public List<ProductResponseDto> findByCategoryAndBrand(@RequestParam String category,@RequestParam String brand){
        return this.productService.getAllProductByCategoryAndBrand(category,brand);
    }

    @PostMapping("/add")
    public ProductResponseDto addProduct(@RequestBody ProductDto productRequestDto) {
        return this.productService.addProduct(productRequestDto);
    }

    @DeleteMapping("product/{productId}/delete")
    @ResponseStatus(NO_CONTENT)
    public void deleteProduct(@PathVariable Long productId){
        this.productService.deleteProductById(productId);
    }

    @PutMapping("product/{productId}/update")
    public ProductResponseDto updateProduct(@RequestBody ProductDto productRequestDto,@PathVariable Long productId){
        return this.productService.updateProduct(productRequestDto,productId);
    }

    @GetMapping("product/count/by-brand/by-name")
    public long countProductByBrandAndName(@RequestParam String brand,@RequestParam String name){
        return this.productService.countProductByBrandAndName(brand,name);
    }


}
