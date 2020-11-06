package com.example.bookshop.repositoryimpl;

import com.example.bookshop.model.Author;
import com.example.bookshop.model.Book;
import com.example.bookshop.model.Genre;
import com.example.bookshop.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
public class GenreRepositoryImpl implements GenreRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public void save(Genre genre) {
        entityManager.persist(genre);
    }

    @Override
    public void delete(Genre genre) {
        entityManager.remove(genre);
    }

    @Override
    public Optional<List<Genre>> getAllGenres() {
        TypedQuery<Genre> query = entityManager.createQuery("SELECT g FROM Genre g", Genre.class);
        return Optional.of(query.getResultList());
    }

    @Override
    public Optional<Genre> find(Genre genre) {
        TypedQuery<Genre> query = entityManager.createQuery("SELECT g FROM Genre g WHERE g.id = :id", Genre.class);
        query.setParameter("id", genre.getId());
        return Optional.of(query.getSingleResult());
    }
}
