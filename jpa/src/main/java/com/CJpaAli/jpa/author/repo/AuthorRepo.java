package com.CJpaAli.jpa.author.repo;

import com.CJpaAli.jpa.author.model.Author;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AuthorRepo extends JpaRepository<Author,Integer> {
    @Transactional
    List<Author> findByNameQuery(@Param("age") int age);

    @Modifying
    @Transactional
    @Query("update Author a set a.firstName = :firstname where a.id = :id")
    void updateAuthor(String firstname, int id);

    @Modifying
    @Transactional
    @Query("update Author a set a.age=  :age")
    int updateAllAuthorAge(int age);

    // Retrieves all authors with the given first name, ignoring case
    List<Author> findAllByFirstNameIgnoreCase(String fn);

    // Retrieves all authors with a first name that ends with the given string
    List<Author> findAllByFirstNameEndingWith(String fn);}
