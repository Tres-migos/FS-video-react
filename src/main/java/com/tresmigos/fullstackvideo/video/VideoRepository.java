package com.tresmigos.fullstackvideo.video;

import com.tresmigos.fullstackvideo.video.Video;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends CrudRepository<Video, Long> {
}
