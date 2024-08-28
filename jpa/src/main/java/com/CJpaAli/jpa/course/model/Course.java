package com.CJpaAli.jpa.course.model;

import com.CJpaAli.jpa.author.model.Author;
import com.CJpaAli.jpa.base.BaseEntity;
import com.CJpaAli.jpa.section.model.Section;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder

@Entity
public class Course extends BaseEntity {

    private String name;
    private String description;
    @OneToMany(mappedBy = "course")
    private List<Section> sections;
}
