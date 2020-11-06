package com.example.bookshop.serviceimpl;

import com.example.bookshop.model.Genre;
import com.example.bookshop.repository.GenreRepository;
import com.example.bookshop.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional(rollbackFor = Throwable.class)
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreRepository genreRepository;

    @Override
    public void save(Genre genre) {
        genreRepository.save(genre);
    }

    @Override
    public void delete(Genre genre) {
        genreRepository.delete(genre);
    }

    @Override
    public void update(Genre genre) {
        Genre genre1 = genreRepository.find(genre).orElseThrow(()->new NoSuchElementException("Genre not found."));
        genreRepository.delete(genre);
    }

    @Override
    public List<Genre> getAllGenres() {
        return genreRepository.getAllGenres().orElseThrow(()->new NoSuchElementException("Genres not found."));
    }
}
