package com.alibou.example.controller;

import com.alibou.example.dto.StudentDto;
import com.alibou.example.model.School;
import com.alibou.example.model.Student;
import com.alibou.example.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController//sprig boot starter web (dependency)
@RequestMapping("api/")
public class StudentController {
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @PostMapping("students")
    public Student post(@RequestBody StudentDto studentDto){
        var student = toStudent(studentDto);
        return studentRepository.save(student);
    }
    @PostMapping("")
    private Student toStudent(StudentDto dto){
        var student= new Student();
        student.setFirstName(dto.firstName());
        student.setLastName(dto.lastName());
        student.setEmail(dto.email());

        var school = new School();
        school.setSchoolId(dto.schoolId());

        student.setSchool(school);
        return student;
    }

    @GetMapping("students/{studentId}")
    public Student findStudentById(@PathVariable("studentId") int id){
        return studentRepository.findById(id).orElse(new Student());
    }

    @GetMapping("students")
    public Iterable<Student> findAll(){
        return studentRepository.findAll();
    }

    @GetMapping("student/search/{student-name}")
    public Iterable<Student> findAllByFirstName(@PathVariable("student-name") String name){
        return studentRepository.findAllByFirstNameContaining(name);
    }

    @DeleteMapping("students/{studentId}")
    @ResponseStatus(HttpStatus.OK)
    public String delete(@PathVariable("studentId") int id){
        studentRepository.deleteById(id);
        return "deleted";
    }

}
