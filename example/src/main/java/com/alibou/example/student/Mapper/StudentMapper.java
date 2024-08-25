package com.alibou.example.student.Mapper;

import com.alibou.example.school.model.School;
import com.alibou.example.student.dto.StudentDto;
import com.alibou.example.student.dto.StudentResponseDto;
import com.alibou.example.student.model.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {


    public Student toStudent(StudentDto dto){
        if (dto == null) {
            throw new NullPointerException("StudentDto cannot be null");
        }
        var student= new Student();
        student.setFirstName(dto.firstName());
        student.setLastName(dto.lastName());
        student.setEmail(dto.email());

        var school = new School();
        school.setId(dto.schoolId());

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
