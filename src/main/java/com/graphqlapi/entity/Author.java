package com.graphqlapi.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Author {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
  private final List<Book> books = new ArrayList<>();

  public Author(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public Author() { }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Book> getBooks() {
    return books;
  }

  @Override
  public String toString() {
    return "Author{" +
      "id=" + id +
      ", name='" + name + '\'' +
      ", books=" + books +
      '}';
  }
}
