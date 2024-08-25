package com.alibou.example.student.dto;

import jakarta.validation.constraints.NotEmpty;


public record StudentDto(

        @NotEmpty(message = "First name cannot be empty") // error 400 bad request when empty
        String firstName,

        @NotEmpty(message = "Last name cannot be empty")
        String lastName,
        String email,

        Integer schoolId
) {
}