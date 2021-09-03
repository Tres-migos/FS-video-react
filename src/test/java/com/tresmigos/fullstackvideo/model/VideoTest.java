package com.tresmigos.fullstackvideo.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;


class VideoTest {
    @InjectMocks
    Video video;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getId() {
        //given
        Long expectedId=5L;
        video.setVideoId(5L);
        //when
        Long actual=video.getVideoId();
        //then
        assertEquals(expectedId,actual);
    }

    @Test
    void getName() {
        //given
        String expectedName="Indian";
        video.setTitle(expectedName);
        //when
        String actual=video.getTitle();
        //then
        assertNull(actual);
    }

    @Test
    void getAccountId() {
        //given
        Integer expectedAccId=54;
        video.setAccountId(expectedAccId);
        //when
        Integer actual=video.getAccountId();
        //then
        assertEquals(expectedAccId,actual);
    }

    @Test
    void getGenre() {
        //given
        String expectedGenre="Indian";
        video.setCategory(expectedGenre);
        //when
        String actual=video.getCategory();
        //then
        assertEquals(expectedGenre,actual);
    }

    @Test
    void getDescription() {
        //given
        String expectedDesc="Classical Music";
        video.setDescription(expectedDesc);
        //when
        String actual=video.getDescription();
        //then
        assertNull(actual);
    }
}