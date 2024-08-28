package com.CJpaAli.jpa.author.repo;

import com.CJpaAli.jpa.author.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<Author,Integer> {
}
