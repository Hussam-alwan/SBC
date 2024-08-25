package com.alibou.example.studentProfile;

import com.alibou.example.student.model.Student;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Profile {

    @Id
    @GeneratedValue
    private Integer id;
    private String bio;

    public Profile(String bie){
        this.bio=bie;
    }

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;


}
