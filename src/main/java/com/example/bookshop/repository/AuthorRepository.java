package com.example.bookshop.repository;

import com.example.bookshop.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository {

    void save (Author author);
    void delete (Author author);
    Optional<List<Author>> getAllAuthors();
    Optional<Author> find(Author author);
}
