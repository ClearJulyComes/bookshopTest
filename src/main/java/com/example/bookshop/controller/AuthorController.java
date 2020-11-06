package com.example.bookshop.controller;

import com.example.bookshop.model.Author;
import com.example.bookshop.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/bookshop/authors")
    List<Author> getAllAuthors(){
        return authorService.getAllAuthors();
    }

    @PostMapping("/bookshop/author/save")
    void saveAuthor(@RequestBody Author author){
        authorService.save(author);
    }

    @PostMapping("/bookshop/author/update")
    void updateAuthor(@RequestBody Author author){
        authorService.update(author);
    }

    @PostMapping("/bookshop/author/delete")
    void deleteAuthor(@RequestBody Author author){
        authorService.delete(author);
    }
}
