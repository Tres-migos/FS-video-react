package com.tresmigos.fullstackvideo.service;

import com.tresmigos.fullstackvideo.model.Comment;
import com.tresmigos.fullstackvideo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository repo;

    public Comment create(Comment comment){
        return repo.save(comment);
    }

    public Comment read(Long id){
        return repo.findById(id).orElse(null);
    }
    public List<Comment> readAll(){
        Iterable<Comment> commentIterable = repo.findAll();
        List<Comment> result = new ArrayList<>();
        commentIterable.forEach(result :: add);
        return  result;
    }

    public Comment update(Long id, Comment newComment){
        Comment commentInDb = read(id);
        return  repo.save(commentInDb);
    }

    public Comment delete(Long id){
        Comment comment = read(id);
        repo.deleteById(id);
        return comment;
    }

    public Comment delete(Comment comment){
        return delete(comment.getCommentId());
    }
}
