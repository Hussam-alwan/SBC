package com.CJpaAli.jpa.author.model;

import com.CJpaAli.jpa.course.model.Course;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_id_seq")
    @SequenceGenerator(name = "author_id_seq", sequenceName = "author_id_seq", allocationSize = 1)
    private Integer id;
    @Column(
            name = "f_name",length=35,nullable = false
    )
    private String firstname;
    private String lastname;
    @Column(unique = true, nullable = false)
    private String email;
    private Integer age;
    @ManyToMany(mappedBy = "authors")
    private List<Course> courses;

}
