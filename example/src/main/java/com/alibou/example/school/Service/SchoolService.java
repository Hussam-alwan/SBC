package com.alibou.example.school.Service;

import com.alibou.example.school.Mapper.SchoolMapper;
import com.alibou.example.school.dto.SchoolDto;
import com.alibou.example.school.repository.SchoolRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService {
    private final SchoolRepo schoolRepo;
    private final SchoolMapper schoolMapper;

    public SchoolService(SchoolRepo schoolRepo, SchoolMapper schoolMapper) {
        this.schoolRepo = schoolRepo;
        this.schoolMapper = schoolMapper;
    }

    public SchoolDto saveSchool(SchoolDto dto) {
        var school = schoolMapper.toSchool(dto);
        var savedSchool = schoolRepo.save(school);
        return schoolMapper.toSchoolDto(savedSchool);
    }

    public List<SchoolDto> findAll() {
        return schoolRepo.findAll()
                .stream()
                .map(schoolMapper::toSchoolDto)
                .collect(Collectors.toList());
    }
}
