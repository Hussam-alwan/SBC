package com.alibou.example.controller;

import com.alibou.example.model.School;
import com.alibou.example.repository.SchoolRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class SchoolController {
    private final SchoolRepo schoolRepo;

    public SchoolController(SchoolRepo schoolRepo) {
        this.schoolRepo = schoolRepo;
    }

    @PostMapping("/schools")
    public School create(@RequestBody School school){
        return schoolRepo.save(school);
    }
    @GetMapping("/schools")
    public List<School> findAll(){
        return schoolRepo.findAll();
    }
}
