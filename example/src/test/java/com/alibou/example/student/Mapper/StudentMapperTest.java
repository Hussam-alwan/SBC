package com.alibou.example.student.Mapper;

import com.alibou.example.student.dto.StudentDto;
import com.alibou.example.student.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {
    private StudentMapper studentMapper;
    @BeforeEach
    void setUp() {
        studentMapper = new StudentMapper();
    }

    @Test
    public void shouldMapStudentDtoToStudent() {

        var dto = new StudentDto(
                "Hussam",
                "Alwan",
                "Hosohoso962@gmail.com",
                1);

        var student = studentMapper.toStudent(dto);
        assertEquals(dto.firstName(), student.getFirstName());
        assertEquals(dto.lastName(), student.getLastName());
        assertEquals(dto.email(), student.getEmail());
        assertNotNull(student.getSchool());
        assertEquals(dto.schoolId(), student.getSchool().getId());
    }

    @Test
    public void should_throw_Null_Pointer_Exception_when_studentId_is_null() {
        var exp =assertThrows(NullPointerException.class,()-> studentMapper.toStudent(null));
        assertEquals("StudentDto cannot be null", exp.getMessage());
    }

    @Test
    public void shouldMapStudentToStudentResponseDto() {
        //giving the student object
        var student = new Student("Hussam", "Alwan", "Hosohoso962@gmail.com");

        //when we map the student object to the response dto
        var responseDto = studentMapper.toStudentResponseDto(student);
        //then the response dto should contain the same data as the student object
        assertEquals(student.getFirstName(), responseDto.firstName());
        assertEquals(student.getLastName(), responseDto.lastName());
        assertEquals(student.getEmail(), responseDto.email());
    }
}