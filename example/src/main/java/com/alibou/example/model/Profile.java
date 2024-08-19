package com.alibou.example.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Profile {

    @Id
    @GeneratedValue
    private int profile_id;
    private String Bio;

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;


}
