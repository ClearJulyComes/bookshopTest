package com.example.bookshop.service;

import com.example.bookshop.model.Author;

import java.util.List;

public interface AuthorService {
    void save (Author author);
    void delete (Author author);
    List<Author> getAllAuthors ();
    void update (Author author);
}
