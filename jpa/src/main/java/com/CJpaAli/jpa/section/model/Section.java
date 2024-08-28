package com.CJpaAli.jpa.section.model;

import com.CJpaAli.jpa.base.BaseEntity;
import com.CJpaAli.jpa.course.model.Course;
import com.CJpaAli.jpa.lecture.model.Lecture;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder

@Entity
public class Section extends BaseEntity {
    private String name;
    private int sectionOrder;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToMany(mappedBy = "section")
    private List<Lecture> lectures;
}
