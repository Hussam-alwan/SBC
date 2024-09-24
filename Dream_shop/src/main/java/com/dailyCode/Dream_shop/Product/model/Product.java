package com.dailyCode.Dream_shop.Product.model;

import com.dailyCode.Dream_shop.Category.model.Category;
import com.dailyCode.Dream_shop.Image.model.Image;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String brand;
    private BigDecimal price;
    private Integer inventory;
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Image > images;
}
