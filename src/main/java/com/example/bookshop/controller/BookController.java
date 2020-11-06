package com.example.bookshop.controller;

import com.example.bookshop.model.Book;
import com.example.bookshop.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/bookshop/book/id/{id}")
    Book getBook(@PathVariable int id){
        return bookService.getBookById(id);
    }

    @GetMapping("/bookshop/books")
    List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @PostMapping("/bookshop/book/save")
    void saveBook(@RequestBody Book book){
        bookService.save(book);
    }

    @PostMapping("/bookshop/book/update")
    void updateBook(@RequestBody Book book){
        bookService.update(book);
    }

    @PostMapping("/bookshop/book/delete")
    void deleteBook(@RequestBody Book book){
        bookService.delete(book);
    }
}
