package com.alibou.example.student.Service;

import com.alibou.example.student.Mapper.StudentMapper;
import com.alibou.example.student.dto.StudentDto;
import com.alibou.example.student.dto.StudentResponseDto;
import com.alibou.example.student.model.Student;
import com.alibou.example.student.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class StudentServiceTest {
    //which service we want test
    @InjectMocks
    private StudentService studentService;

    //declare the dependencies
    @Mock
    private StudentRepository studentRepository;
    @Mock
    private StudentMapper studentMapper;



    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void  should_successfully_save_student() {
        //given
        var dto = new StudentDto("Hussam", "Alwan", "Hosohoso962@gmail.com", 1);
        var student = new Student(10, "Hussam", "Alwan", "Hosohoso962@gmail.com");
        var savedStudent = new Student(10, "Hussam", "Alwan", "Hosohoso962@gmail.com");
        savedStudent.setId(1);
        //mock the  calls
        when(studentMapper.toStudent(dto)).thenReturn(student);
        when(studentRepository.save(student)).thenReturn(savedStudent);
        when(studentMapper.toStudentResponseDto(savedStudent)).thenReturn(new StudentResponseDto("Hussam", "Alwan", "Hosohoso962@gmail.com"));
        //when
        var responseDto = studentService.saveStudent(dto);
        //then
        assertEquals(dto.firstName(), responseDto.firstName());
        assertEquals(dto.lastName(), responseDto.lastName());
        assertEquals(dto.email(), responseDto.email());

        //verify the calls
        verify(studentMapper,times(1)).toStudent(dto);
        verify(studentRepository,times(1)).save(student);
        verify(studentMapper,times(1)).toStudentResponseDto(savedStudent);


    }

    @Test
    public void should_return_all_students(){
        List<Student> students=new ArrayList<>();
        var student1 = new Student(10, "Hussam", "Alwan", "Hosohoso962@gmail.com");
        var student2 = new Student(11, "Hussam", "Alwan", "Hosohoso962@gmail.com");
        students.add(student1);
        students.add(student2);
        //mock the calls
        when(studentRepository.findAll()).thenReturn(students);
        when(studentMapper.toStudentResponseDto(any(Student.class))).thenReturn(new StudentResponseDto("Hussam", "Alwan", "Hosohoso962@gmail.com"));
        //when
        List<StudentResponseDto> responseDto = (List<StudentResponseDto>) studentService.findAll();
        //then
        assertEquals(students.size(),responseDto.size());
        //verify the calls
        verify(studentRepository,times(1)).findAll();
        verify(studentMapper,times(2)).toStudentResponseDto(any(Student.class));
    }

    @Test
    public void should_return_student_by_id(){
        var student = new Student( "Hussam", "Alwan", "Hosohoso962@gmail.com");
        int id = 10;
        //mock the calls
        when(studentRepository.findById(anyInt())).thenReturn(Optional.of(student));
        when(studentMapper.toStudentResponseDto(any(Student.class))).thenReturn(new StudentResponseDto("Hussam", "Alwan", "Hosohoso962@gmail.com"));
        //when
        var responseDto = studentService.findStudentById(id);
        //then
        assertEquals(responseDto.firstName(),student.getFirstName());
        assertEquals(responseDto.lastName(),student.getLastName());
        assertEquals(responseDto.email(),student.getEmail());
        //verify the calls
        verify(studentRepository,times(1)).findById(id);
        verify(studentMapper,times(1)).toStudentResponseDto(any(Student.class));
    }

    @Test
    public void should_find_student_by_name(){
        var student1 = new Student( "Hussam", "Alwan", "Hosohoso962@gmail.com");
        var student2= new Student( "Hussam", "Alwan", "Hosohoso962@gmail.com");
        String name = "Hussam";
        List<Student> students=new ArrayList<>();
        students.add(student1);
        students.add(student2);
        //mock the calls
        when(studentRepository.findAllByFirstNameContaining(name)).thenReturn(students);
        when(studentMapper.toStudentResponseDto(any(Student.class))).thenReturn(new StudentResponseDto("Hussam", "Alwan", "Hosohoso962@gmail.com"));
        //when
        var responseDto= studentService.findAllByFirstName(name);
        //then
        assertEquals(responseDto.size(),students.size());
        //verify the calls
        verify(studentRepository,times(1)).findAllByFirstNameContaining(name);
        verify(studentMapper,times(2)).toStudentResponseDto(any(Student.class));

        // assert
        assertEquals(students.size(),responseDto.size());
        verify(studentRepository,times(1)).findAllByFirstNameContaining(name);
    }
}