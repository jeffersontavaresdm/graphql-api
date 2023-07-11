package com.graphqlapi;

import com.graphqlapi.entity.Author;
import com.graphqlapi.entity.Book;
import com.graphqlapi.repository.AuthorRepository;
import com.graphqlapi.repository.BookRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class GraphqlApiApplication {

  public static void main(String[] args) {
    SpringApplication.run(GraphqlApiApplication.class, args);
  }

  @Bean
  ApplicationRunner applicationRunner(AuthorRepository authorRepository, BookRepository bookRepository) {
    return applicationArguments -> {
      Author josh = authorRepository.save(new Author(null, "Josh Long"));
      Author mark = authorRepository.save(new Author(null, "Mark Heckler"));

      bookRepository.saveAll(List.of(
        new Book("Reactive Spring", "Josh Long's", josh),
        new Book("Cloud Native Java", "Josh Long's", josh),
        new Book("Spring Boot: Up & Running", "Mark Heckler", mark)
      ));
    };
  }
}
