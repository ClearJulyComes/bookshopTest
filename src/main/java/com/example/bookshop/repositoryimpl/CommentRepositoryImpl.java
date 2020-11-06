package com.example.bookshop.repositoryimpl;

import com.example.bookshop.model.Comment;
import com.example.bookshop.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Optional;

@Repository
public class CommentRepositoryImpl implements CommentRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public void save(Comment comment) {
        entityManager.persist(comment);
    }

    @Override
    public Optional<Comment> getCommentById(int id) {
        TypedQuery<Comment> query =
                entityManager.createQuery("SELECT c FROM Comment c WHERE c.id = :id", Comment.class);
        query.setParameter("id", id);
        return Optional.of(query.getSingleResult());
    }

    @Override
    public void delete(Comment comment) {
        entityManager.remove(comment);
    }
}
