package com.alibou.example.student.Service;

import com.alibou.example.student.dto.StudentDto;
import com.alibou.example.student.dto.StudentResponseDto;
import com.alibou.example.student.repository.StudentRepository;
import org.springframework.stereotype.Service;
import com.alibou.example.student.Mapper.StudentMapper;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }
    public StudentResponseDto saveStudent(StudentDto dto){
        var student = studentMapper.toStudent(dto);
        var savedStudent= studentRepository.save(student);
        return studentMapper.toStudentResponseDto(savedStudent);
    }
    public StudentResponseDto findStudentById(Integer id){
        return studentRepository.findById(id)
                .map(studentMapper::toStudentResponseDto)
                .orElse(null);
    }
    public Iterable<StudentResponseDto> findAll(){
        return studentRepository.findAll()
                .stream()
                .map(studentMapper::toStudentResponseDto)
                .collect(Collectors.toList());
    }

    public List<StudentResponseDto> findAllByFirstName(String name){
        return studentRepository.findAllByFirstNameContaining(name)
                .stream()
                .map(studentMapper::toStudentResponseDto)
                .collect(Collectors.toList());
    }

    public String delete(int id){
        studentRepository.deleteById(id);
        return "deleted";
    }

}
