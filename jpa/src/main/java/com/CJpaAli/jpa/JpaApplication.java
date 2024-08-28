package com.CJpaAli.jpa;

import com.CJpaAli.jpa.author.model.Author;
import com.CJpaAli.jpa.author.repo.AuthorRepo;
import com.CJpaAli.jpa.specification.AuthorSpecif;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.domain.Specification;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(
			AuthorRepo authorRepo
	){
		return args -> {
			var author = Author.builder().firstName("hussam").lastname("alwan").age(20).email("hosohoso962@gmail.com").build();
			authorRepo.save(author);
			//authorRepo.updateAllAuthorAge(10);
			authorRepo.findByNameQuery(2).forEach(System.out::println);
			Specification<Author> spec= Specification.where(AuthorSpecif.hasAge(34))
					.and(AuthorSpecif.firstNameLike("hu%"));
			authorRepo.findAll().forEach(System.out::println);

		};
	}

}
