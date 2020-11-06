package com.example.bookshop.service;

import com.example.bookshop.model.Genre;

import java.util.List;

public interface GenreService {
    void save (Genre genre);
    void delete (Genre genre);
    void update (Genre genre);
    List<Genre> getAllGenres ();
}
