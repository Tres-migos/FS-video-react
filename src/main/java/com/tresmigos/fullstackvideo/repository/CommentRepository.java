package com.tresmigos.fullstackvideo.repository;

import com.tresmigos.fullstackvideo.model.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
}
