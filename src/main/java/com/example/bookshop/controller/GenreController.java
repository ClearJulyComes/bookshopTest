package com.example.bookshop.controller;

import com.example.bookshop.model.Genre;
import com.example.bookshop.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GenreController {

    @Autowired
    private GenreService genreService;

    @GetMapping("/bookshop/genres")
    List<Genre> getAllGenres(){
        return genreService.getAllGenres();
    }

    @PostMapping("/bookshop/genre/save")
    void saveGenre(@RequestBody Genre genre){
        genreService.save(genre);
    }

    @PostMapping("/bookshop/genre/update")
    void updateGenre(@RequestBody Genre genre){
        genreService.update(genre);
    }

    @PostMapping("/bookshop/genre/delete")
    void deleteGenre(@RequestBody Genre genre){
        genreService.delete(genre);
    }
}
