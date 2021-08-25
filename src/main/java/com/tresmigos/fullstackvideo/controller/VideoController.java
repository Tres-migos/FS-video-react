package com.tresmigos.fullstackvideo.controller;


import com.tresmigos.fullstackvideo.model.Video;
import com.tresmigos.fullstackvideo.repository.VideoRepository;
import com.tresmigos.fullstackvideo.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VideoController {
    private VideoService service;

    @Autowired
    private VideoController(VideoService service) {
        this.service = service;
    }




}
