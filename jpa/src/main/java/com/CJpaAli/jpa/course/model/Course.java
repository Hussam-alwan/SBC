package com.CJpaAli.jpa.course.model;

import com.CJpaAli.jpa.author.model.Author;
import com.CJpaAli.jpa.section.model.Section;
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
public class Course {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String description;
    @ManyToMany
    @JoinTable(
            name = "author_course",
            joinColumns = {
                    @JoinColumn(name = "course_id")// hold the primary key for the owner of the relationship
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "author_id")
            }

    )
    private List<Author> authors; // <>

    @OneToMany(mappedBy = "course")
    private List<Section> sections;
}
