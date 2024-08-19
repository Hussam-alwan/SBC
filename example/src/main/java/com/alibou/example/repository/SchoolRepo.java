package com.alibou.example.repository;

import com.alibou.example.model.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepo extends JpaRepository<School,Integer> {

}
