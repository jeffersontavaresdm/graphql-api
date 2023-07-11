package com.graphqlapi.config;

import com.graphqlapi.entity.Author;
import com.graphqlapi.entity.Book;
import com.graphqlapi.repository.AuthorRepository;
import com.graphqlapi.repository.BookRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import java.util.List;

public record CustomApplicationRunner(
  AuthorRepository authorRepository,
  BookRepository bookRepository
) implements ApplicationRunner {

  @Override
  public void run(ApplicationArguments args) {
    Author josh = authorRepository.save(new Author(null, "Josh Long"));
    Author mark = authorRepository.save(new Author(null, "Mark Heckler"));

    bookRepository.saveAll(List.of(
      new Book("Reactive Spring", "Josh Long's", josh),
      new Book("Cloud Native Java", "Josh Long's", josh),
      new Book("Spring Boot: Up & Running", "Mark Heckler", mark)
    ));
  }
}