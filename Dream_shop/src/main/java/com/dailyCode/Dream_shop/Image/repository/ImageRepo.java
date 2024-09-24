package com.dailyCode.Dream_shop.Image.repository;

import com.dailyCode.Dream_shop.Image.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepo extends JpaRepository<Image,Long> {
}
