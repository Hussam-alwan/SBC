package com.dailyCode.Dream_shop.Image.model;

import com.dailyCode.Dream_shop.Product.model.Product;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Blob;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;
    private String fileType;
    @Lob
    private Blob image;
    private String downloadUrl;

    @ManyToOne
    @JoinColumn
    private Product product;
}
