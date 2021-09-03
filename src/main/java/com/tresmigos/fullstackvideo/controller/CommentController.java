package com.tresmigos.fullstackvideo.controller;

import com.tresmigos.fullstackvideo.model.Comment;
import com.tresmigos.fullstackvideo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/comment")
@CrossOrigin(origins = "*")
public class CommentController {

    @Autowired
    CommentService service;

    @PostMapping("/")
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment) {
        return new ResponseEntity<>(service.create(comment), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> readCommentById(@PathVariable Long id) {
        return new ResponseEntity<>(service.read(id), HttpStatus.OK);
    }

    @GetMapping("/allComment")
    public ResponseEntity<List<Comment>> readAllComments() {
        return new ResponseEntity<>(service.readAll(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Comment> updatePost(@PathVariable Long id, @RequestBody Comment comment) {
        return new ResponseEntity<>(service.update(id, comment), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Comment> deletePost(@RequestBody Comment comment) {
        return new ResponseEntity<>(service.delete(comment), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Comment> deletePostById(@PathVariable Long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }


}
