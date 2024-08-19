package com.alibou.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue
    private int id;
    private int age;
    private String firstName;
    private String lastName;
    private String email;
    @OneToOne(
            cascade = CascadeType.ALL,
            mappedBy = "student"
    )
    private Profile profile;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "school_id")
    @JsonBackReference
    private School school;


}
