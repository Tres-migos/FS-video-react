package com.tresmigos.fullstackvideo.controller;

import com.amazonaws.services.s3.model.ObjectListing;
import com.tresmigos.fullstackvideo.model.Video;
import com.tresmigos.fullstackvideo.service.AwsServiceClient;
import com.tresmigos.fullstackvideo.service.VideoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

class VideoControllerTest {
    @InjectMocks
    VideoController videoController;

    @Mock
    VideoService service;
    @Mock
    AwsServiceClient awsServiceClient;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    void read() {
        //given
        Video video=new Video();
        ResponseEntity<Video>expected=new ResponseEntity<>(video,HttpStatus.OK);
        //when
        Mockito.doReturn(video).when(service).read(Mockito.anyLong());
        ResponseEntity<Video>actual=videoController.read(Mockito.anyLong());
        //then
        assertEquals(expected,actual);
    }

    @Test
    void updateVideoById() {
        //given
        Video video = new Video();
        ResponseEntity<Video> expected = new ResponseEntity<>(video,HttpStatus.OK);

        //when
        Mockito.when(service.update(5L, video)).thenReturn(video);

        ResponseEntity<Video> actual = videoController.updateVideoById(5L,video);

        //Then
        assertEquals(expected,actual);
    }

    @Test
    void deleteVideoById() {
        //given
        Video video = new Video();
        ResponseEntity<Video> expected = new ResponseEntity<>(video,HttpStatus.OK);

        //when
        Mockito.doReturn(video).when(service).delete(Mockito.anyLong());
        ResponseEntity<Video> actual = videoController.deleteVideoById(Mockito.anyLong());

        //Then
        assertEquals(expected,actual);
    }
}