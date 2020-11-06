package com.example.bookshop.repositoryimpl;

import com.example.bookshop.model.Book;
import com.example.bookshop.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Repository
public class BookRepositoryImpl implements BookRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public void save(Book book) {
        entityManager.persist(book);
    }

    @Override
    public void delete(Book book) {
        entityManager.remove(book);
    }

    @Override
    public Optional<List<Book>> getAllBooks() {
        TypedQuery<Book> query = entityManager.createQuery("SELECT b FROM  Book b", Book.class);
        return Optional.of(query.getResultList());
    }

    @Override
    public Optional<Book> getBookById(int id) {
        TypedQuery<Book> query = entityManager.createQuery("SELECT b FROM Book b WHERE b.id = :id", Book.class);
        query.setParameter("id", id);
        return Optional.of(query.getSingleResult());
    }
}
