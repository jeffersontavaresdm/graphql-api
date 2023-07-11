package com.graphqlapi.service;

import com.graphqlapi.entity.Author;
import com.graphqlapi.entity.Book;
import com.graphqlapi.entity.dto.AuthorInput;
import com.graphqlapi.entity.dto.BookInput;
import com.graphqlapi.repository.AuthorRepository;
import com.graphqlapi.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

  private final AuthorRepository authorRepository;
  private final BookRepository bookRepository;

  public AuthorService(AuthorRepository authorRepository, BookRepository bookRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
  }

  public List<Author> getAuthors() {
    return authorRepository.findAll();
  }

  public Optional<Author> findAuthorById(Long id) {
    return authorRepository.findById(id);
  }

  public Book addBook(BookInput bookInput) {
    if (bookInput == null) throw new IllegalArgumentException();

    Optional<Author> optionalAuthor = authorRepository.findById(bookInput.authorId());

    if (optionalAuthor.isPresent()) {
      Author author = optionalAuthor.get();
      Book book = new Book(bookInput.title(), bookInput.publisher(), author);
      bookRepository.save(book);
      return book;
    }

    throw new IllegalArgumentException("Something wrong...");
  }

  public Author updateAuthorById(Long id, AuthorInput authorInput) {
    Optional<Author> optionalAuthor = authorRepository.findById(id);

    if (optionalAuthor.isPresent()) {
      Author author = optionalAuthor.get();

      author.setName(authorInput.name());
      authorRepository.save(author);
      return author;
    }

    throw new IllegalArgumentException("Author not found");
  }

  public void deleteAuthorById(Long id) {
    authorRepository.deleteById(id);
  }
}
