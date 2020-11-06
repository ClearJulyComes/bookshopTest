package com.example.bookshop.service;

import com.example.bookshop.model.Comment;

public interface CommentService {
    void saveComment (Comment comment);
    void deleteComment (Comment comment);
    void updateComment (Comment comment);
    Comment getCommentById(int id);
}
