package com.tresmigos.fullstackvideo.service;

import com.tresmigos.fullstackvideo.model.Video;
import com.tresmigos.fullstackvideo.repository.VideoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

class VideoServiceTest {
    @InjectMocks
    VideoService videoService;

    @Mock
    VideoRepository repository;

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
        Mockito.doReturn(expected).when(repository).save(video);
        Video actual=videoService.create(video);
        //then
        assertEquals(expected,actual);
    }

    @Test
    void readAll() {
        //given
        Video video = new Video();
        List<Video> result = new ArrayList<>();
        result.add(new Video());
        List expected = new ArrayList();

        //when
        Mockito.doReturn(expected).when(repository).findAll();
        List Actual = videoService.readAll();

        //Then
        assertEquals(expected,Actual);
    }

    @Test
    void read() {
        //given
        List<Long> id = new ArrayList<>();
        Video video = new Video();
        Video expected = new Video();

        //when
        when(repository.findById(anyLong())).thenReturn(Optional.of(expected));
        Video Actual =videoService.read(Mockito.anyLong());

        //Then
        assertEquals(expected,Actual);

    }


    @Test
    void update() {
        //given
        List<Long> id = new ArrayList<>();
        id.add(5L);
        id.add(6L);
        Video video = new Video();
        video.setCategory("rock");
        video.setDescription("latest rock songs");
        video.setAccountId(5);


        //when
        when(repository.findById(anyLong())).thenReturn(Optional.of(video));
        when(repository.save(video)).thenReturn(video);

        Video Actual = videoService.update(Mockito.anyLong(),video);

        //Then
        assertEquals(video,Actual);
    }

    @Test
    void delete() {
        //given
        Video video = new Video();

        //when
        Mockito.when(repository.findById(2L)).thenReturn(Optional.of(video));
        Video actual = videoService.delete(2L);

        //Then
        assertEquals(video,actual);
    }
}