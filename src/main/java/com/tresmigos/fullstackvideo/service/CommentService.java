package com.tresmigos.fullstackvideo.service;

import com.tresmigos.fullstackvideo.model.Account;
import com.tresmigos.fullstackvideo.model.Comment;
import com.tresmigos.fullstackvideo.repository.AccountRepository;
import com.tresmigos.fullstackvideo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {

    private CommentRepository repo;

    @Autowired
    public CommentService(CommentRepository repository){
        this.repo = repository;
    }

    public Comment create(Comment comment){
        return repo.save(comment);
    }

    public Comment read(Long id){
        return repo.findById(id).orElse(null);
    }
    public List<Comment> readAll(){
        Iterable<Comment> accountIterable = repo.findAll();
        List<Comment> result = new ArrayList<>();
        accountIterable.forEach(result :: add);
        return result;
    }

    public Comment update(Long id, Comment newCommentData){
        Comment commentInDb = read(id);
        commentInDb.setText(newCommentData.getText());
        commentInDb.setDatePosted(newCommentData.getDatePosted());
        return  repo.save(commentInDb);
    }

    public Comment delete(Long id){
        Comment commentInDb = read(id);
        repo.deleteById(id);
        return commentInDb;
    }

    public Comment delete(Comment comment){
        return delete(comment.getCommentId());
    }
}
