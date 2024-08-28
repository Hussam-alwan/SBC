package com.CJpaAli.jpa;

import com.CJpaAli.jpa.author.model.Author;
import com.CJpaAli.jpa.author.repo.AuthorRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}
	//@Bean
	public CommandLineRunner commandLineRunner(
			AuthorRepo authorRepo
	){
		return args -> {
			var author = Author.builder().firstname("hussam").lastname("alwan").age(20).email("hosohoso962@gmail.com").build();
			authorRepo.save(author);
		};
	}

}
