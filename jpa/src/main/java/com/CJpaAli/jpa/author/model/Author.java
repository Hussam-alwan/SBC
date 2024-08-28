package com.CJpaAli.jpa.author.model;

import com.CJpaAli.jpa.base.BaseEntity;
import com.CJpaAli.jpa.course.model.Course;
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
@NamedQuery(
        name = "Author.findByNameQuery",
        query = "select a from Author a where a.age>= :age"
)
public class Author extends BaseEntity {
    @Column(
            name = "f_name",length=35,nullable = false
    )
    private String firstName;
    private String lastname;
    @Column(unique = true, nullable = false)
    private String email;
    private Integer age;


}
