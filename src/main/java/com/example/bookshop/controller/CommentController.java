package com.example.bookshop.controller;

import com.example.bookshop.model.Comment;
import com.example.bookshop.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/bookshop/comment/id/{id}")
    Comment getComment(@PathVariable int id){
        return commentService.getCommentById(id);
    }

    @PostMapping("/bookshop/comment/save")
    void saveComment(@RequestBody Comment comment){
        commentService.saveComment(comment);
    }

    @PostMapping("/bookshop/comment/update")
    void updateComment(@RequestBody Comment comment){
        commentService.updateComment(comment);
    }

    @PostMapping("/bookshop/comment/delete")
    void deleteComment(@RequestBody Comment comment){
        commentService.deleteComment(comment);
    }
}
