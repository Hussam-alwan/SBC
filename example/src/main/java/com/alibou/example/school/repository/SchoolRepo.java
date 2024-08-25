package com.alibou.example.school.repository;

import com.alibou.example.school.model.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepo extends JpaRepository<School,Integer> {

}
