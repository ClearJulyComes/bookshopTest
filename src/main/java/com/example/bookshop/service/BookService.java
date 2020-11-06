package com.example.bookshop.service;

import com.example.bookshop.model.Book;

import java.util.List;

public interface BookService {
    void save (Book book);
    void delete (Book book);
    void update (Book book);
    Book getBookById (int id);
    List<Book> getAllBooks ();
}
