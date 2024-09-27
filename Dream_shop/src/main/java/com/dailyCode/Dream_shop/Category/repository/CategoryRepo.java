package com.dailyCode.Dream_shop.Category.repository;

import com.dailyCode.Dream_shop.Category.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category,Long> {
    Category findByName(String name);
    boolean existsByName(String name);
}
