package com.tresmigos.fullstackvideo.repository;

import com.tresmigos.fullstackvideo.model.Video;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends CrudRepository<Video, Long> {
}
