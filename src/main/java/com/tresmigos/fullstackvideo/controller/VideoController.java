package com.tresmigos.fullstackvideo.controller;


import com.amazonaws.services.s3.model.ObjectListing;
import com.tresmigos.fullstackvideo.model.Video;
import com.tresmigos.fullstackvideo.service.AwsServiceClient;
import com.tresmigos.fullstackvideo.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/video")
@CrossOrigin(origins = "*")
public class VideoController {

    @Autowired
    VideoService service;

    @Autowired
    private AwsServiceClient AWS_CLIENT;

    public VideoController(VideoService serv) {
        this.service = serv;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<ObjectListing> readAll() {
        return new ResponseEntity<ObjectListing>(AWS_CLIENT.getListOfObjects("tres-migos-videos"), HttpStatus.OK);
    }

    @GetMapping(value = "/{bucket}/{objectKey}")
    public ResponseEntity<String> getVideoURL(@PathVariable String bucket, @PathVariable String objectKey) {
        return new ResponseEntity<String>(AWS_CLIENT.getObjUrl(bucket, objectKey), HttpStatus.OK);
    }

//    @PostMapping(value = "/upload")
//    public ResponseEntity<Video> uploadVideo(@RequestParam("file") MultipartFile file, @ModelAttribute Video video) {
//        System.out.println(file);
//        return new ResponseEntity<>(service.create(video), HttpStatus.CREATED);
//    }

    @GetMapping(value = "/getVideo/{id}")
    public ResponseEntity<Video> read(@PathVariable Long id) {
        return new ResponseEntity<>(service.read(id),HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Video> updateVideoById(@PathVariable Long id, @RequestBody Video newVideo){
        return new ResponseEntity<>(service.update(id, newVideo), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Video> deleteVideoById(@PathVariable Long id){
        return new ResponseEntity<>(service.delete(id),HttpStatus.OK);
    }

}
