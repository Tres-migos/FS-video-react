package com.tresmigos.fullstackvideo.controller;


import com.tresmigos.fullstackvideo.model.Video;
import com.tresmigos.fullstackvideo.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VideoController {
    private VideoRepository videoRepository;

    @Autowired
    private VideoController(VideoRepository repo) {
        this.videoRepository = repo;
    }




}
