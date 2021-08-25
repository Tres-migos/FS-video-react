package com.tresmigos.fullstackvideo.controller;


import com.tresmigos.fullstackvideo.model.Video;
import com.tresmigos.fullstackvideo.repository.VideoRepository;
import com.tresmigos.fullstackvideo.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/video-controller")
public class VideoController {

    @Autowired
    private VideoService service;


    public VideoController(VideoService serv) {
        this.service = serv;
    }

    @PostMapping(value = "/createVideo")
    public ResponseEntity<Video> createVideo(@RequestBody Video video) {
        return new ResponseEntity<>(service.create(video), HttpStatus.CREATED);
    }

    @GetMapping(value = "/getVideo/{id}")
    public ResponseEntity<Video> read(@PathVariable Long id) {
        return new ResponseEntity<>(service.read(id),HttpStatus.OK);
    }

    @GetMapping(value = "/readAll")
    public ResponseEntity<List<Video>> readAll(){
        return new ResponseEntity<>(service.readAll(), HttpStatus.OK);
    }


    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Video> update(@PathVariable Long id, @RequestBody Video newVideo){
        return new ResponseEntity<>(service.update(id, newVideo), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Video> delete(@PathVariable Long id){
        return new ResponseEntity<>(service.delete(id),HttpStatus.OK);
    }

}
