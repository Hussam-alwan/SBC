package com.alibou.example.student.controller;

import com.alibou.example.student.Service.StudentService;
import com.alibou.example.student.dto.StudentDto;
import com.alibou.example.student.dto.StudentResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController//sprig boot starter web (dependency)
@RequestMapping("api/")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("students")
    public StudentResponseDto saveStudent(
         @Valid @RequestBody StudentDto studentDto
    ){
        return this.studentService.saveStudent(studentDto);
    }


    @GetMapping("students/{studentId}")
    public StudentResponseDto findStudentById(@PathVariable("studentId") int id){
        return studentService.findStudentById(id);
    }

    @GetMapping("students")
    public Iterable<StudentResponseDto> findAll(){
       return studentService.findAll();
    }

    @GetMapping("student/search/{student-name}")
    public List<StudentResponseDto> findAllByFirstName(@PathVariable("student-name") String name){
        return studentService.findAllByFirstName(name);
    }

    @DeleteMapping("students/{studentId}")
    @ResponseStatus(HttpStatus.OK)
    public String delete(@PathVariable("studentId") int id){
        return studentService.delete(id);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exp
    ){
        var errors = new HashMap<String,String>();
        exp.getBindingResult().getAllErrors().forEach((error)->{
            var fieldName= ((FieldError) error).getField();
            var errorMessage=error.getDefaultMessage();
            errors.put(fieldName,errorMessage);
        });
        return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
    }

}
