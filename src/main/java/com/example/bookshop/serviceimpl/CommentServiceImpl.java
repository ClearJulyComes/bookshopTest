package com.example.bookshop.serviceimpl;

import com.example.bookshop.model.Comment;
import com.example.bookshop.repository.CommentRepository;
import com.example.bookshop.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@Transactional(rollbackFor = Throwable.class)
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public void saveComment(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void deleteComment(Comment comment) {
        commentRepository.delete(comment);
    }

    @Override
    public void updateComment(Comment comment) {
        Comment comment1 = getCommentById(comment.getId());
        commentRepository.save(comment);
    }

    @Override
    public Comment getCommentById(int id) {
        return commentRepository.getCommentById(id).orElseThrow(()->new NoSuchElementException("Comment not found."));
    }
}
