package com.alibou.example.repository;

import com.alibou.example.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    List<Student> findAllByFirstNameContaining(String name);

}
