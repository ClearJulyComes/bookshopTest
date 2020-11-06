package com.example.bookshop.repository;

import com.example.bookshop.model.Comment;
import java.util.Optional;

public interface CommentRepository {

    void save (Comment comment);
    Optional<Comment> getCommentById(int id);
    void delete (Comment comment);
}
