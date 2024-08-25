package com.alibou.example.student.model;

import com.alibou.example.studentProfile.Profile;
import com.alibou.example.school.model.School;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue
    private Integer id;
    private int age;
    private String firstName;
    private String lastName;
    private String email;

    @OneToOne(
            mappedBy = "student",
            cascade = CascadeType.ALL
    )
    private Profile profile;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "school_id")
    @JsonBackReference
    private School school;

    public Student(int age, String firstName, String lastName, String email) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Student(String hussam, String alwan, String mail) {
        this.firstName = hussam;
        this.lastName = alwan;
        this.email = mail;
    }
}
