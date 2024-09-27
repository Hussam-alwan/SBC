package com.dailyCode.Dream_shop.Image.repository;

import com.dailyCode.Dream_shop.Image.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepo extends JpaRepository<Image,Long> {
    List<Image> findByProductId(Long id);
}
