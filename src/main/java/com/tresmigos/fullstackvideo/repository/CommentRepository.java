package com.tresmigos.fullstackvideo.repository;

import com.tresmigos.fullstackvideo.model.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {
}
