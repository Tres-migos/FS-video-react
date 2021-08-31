package com.tresmigos.fullstackvideo.service;

import com.tresmigos.fullstackvideo.model.Video;
import com.tresmigos.fullstackvideo.repository.VideoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class VideoServiceTest {
    @InjectMocks
    VideoService videoService;

    @Mock
    VideoRepository videoRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void create() {
        //given
        Video video=new Video();
        Video expected=new Video();
        //when
        Mockito.doReturn(expected).when(videoRepository).save(video);
        Video actual=videoService.create(video);
        //then
        assertEquals(expected,actual);
    }

    @Test
    void read() {
    }

    @Test
    void readAll() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}