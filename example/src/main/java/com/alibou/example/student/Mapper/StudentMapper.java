package com.alibou.example.student.Mapper;

import com.alibou.example.school.repository.SchoolRepo;
import com.alibou.example.student.dto.StudentDto;
import com.alibou.example.student.dto.StudentResponseDto;
import com.alibou.example.student.model.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {

    private final SchoolRepo schoolRepo;

    public StudentMapper(SchoolRepo schoolRepo) {
        this.schoolRepo = schoolRepo;
    }


    public Student toStudent(StudentDto dto){
        if (dto == null) {
            throw new NullPointerException("StudentDto cannot be null");
        }

        var student= new Student();
        student.setFirstName(dto.firstName());
        student.setLastName(dto.lastName());
        student.setEmail(dto.email());

        var school =schoolRepo.findById(dto.schoolId()).orElseThrow(() -> new IllegalArgumentException("School not found with id: " + dto.schoolId()));

        student.setSchool(school);
        return student;
    }
    public StudentResponseDto toStudentResponseDto(Student student){
        return new StudentResponseDto(
                student.getFirstName(),
                student.getLastName(),
                student.getEmail()
        );
    }
}
