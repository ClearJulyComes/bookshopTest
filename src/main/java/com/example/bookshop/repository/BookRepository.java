package com.example.bookshop.repository;

import com.example.bookshop.model.Author;
import com.example.bookshop.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {

    void save (Book book);
    void delete (Book book);
    Optional<List<Book>> getAllBooks();
    Optional<Book> getBookById(int id);
}
