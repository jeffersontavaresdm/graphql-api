package com.graphqlapi.controller;

import com.graphqlapi.entity.Author;
import com.graphqlapi.entity.Book;
import com.graphqlapi.entity.dto.AuthorInput;
import com.graphqlapi.entity.dto.BookInput;
import com.graphqlapi.service.AuthorService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class AuthorController {

  private final AuthorService authorService;

  public AuthorController(AuthorService authorService) {
    this.authorService = authorService;
  }

  @QueryMapping
  public Iterable<Author> authors() {
    return authorService.getAuthors();
  }

  @QueryMapping
  public Optional<Author> authorById(@Argument Long id) {
    return authorService.findAuthorById(id);
  }

  @MutationMapping
  public Book addBook(@Argument BookInput bookInput) {
    return authorService.addBook(bookInput);
  }

  @MutationMapping
  public Author updateAuthor(@Argument Long id, @Argument AuthorInput authorInput) {
    return authorService.updateAuthorById(id, authorInput);
  }

  @MutationMapping
  public void deleteAuthor(@Argument Long id) {
    authorService.deleteAuthorById(id);
  }
}
