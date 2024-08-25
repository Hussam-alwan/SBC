package com.alibou.example.school.Mapper;

import com.alibou.example.school.dto.SchoolDto;
import com.alibou.example.school.model.School;
import org.springframework.stereotype.Service;

@Service
public class SchoolMapper {

    public School toSchool(SchoolDto dto){
        return new School(dto.name());
    }
    public SchoolDto toSchoolDto(School school){
        return  new SchoolDto(school.getName());
    }

}
