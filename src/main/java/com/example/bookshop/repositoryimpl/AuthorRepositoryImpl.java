package com.example.bookshop.repositoryimpl;

import com.example.bookshop.model.Author;
import com.example.bookshop.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
public class AuthorRepositoryImpl implements AuthorRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public void save(Author author) {
        entityManager.persist(author);
    }

    @Override
    public void delete(Author author) {
        entityManager.remove(author);
    }

    @Override
    public Optional<List<Author>> getAllAuthors() {
        TypedQuery<Author> query =
                entityManager.createQuery("SELECT a FROM Author a", Author.class);
        return Optional.of(query.getResultList());
    }

    @Override
    public Optional<Author> find(Author author) {
        TypedQuery<Author> query =
                entityManager.createQuery("SELECT a FROM Author a WHERE a.id= :id", Author.class);
        query.setParameter("id", author.getId());
        return Optional.of(query.getSingleResult());
    }
}
