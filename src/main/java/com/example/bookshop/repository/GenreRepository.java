package com.example.bookshop.repository;

import com.example.bookshop.model.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreRepository {

    void save (Genre genre);
    void delete (Genre genre);
    Optional<List<Genre>> getAllGenres();
    Optional<Genre> find(Genre genre);
}
