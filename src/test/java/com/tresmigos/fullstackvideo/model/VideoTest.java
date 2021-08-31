package com.tresmigos.fullstackvideo.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import sun.jvm.hotspot.utilities.Assert;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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
        video.setId(5L);
        //when
        Long actual=video.getId();
        //then
        System.out.println(actual);
        assertEquals(expectedId,actual);
    }

    @Test
    void getName() {
        //given
        String expectedName="Indian";
        video.setName(expectedName);
        //when
        String actual=video.getName();
        //then
        //assertNull(actual);
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
        video.setGenre(expectedGenre);
        //when
        String actual=video.getGenre();
        //then
        assertEquals(expectedGenre,actual);
    }

    @Test
    void getDescription() {
        //given
        String expectedDesc="Classical Music";
        video.setName(expectedDesc);
        //when
        String actual=video.getDescription();
        //then
        assertNull(actual);
    }
}