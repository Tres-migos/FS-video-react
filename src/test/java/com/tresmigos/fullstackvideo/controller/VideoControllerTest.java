package com.tresmigos.fullstackvideo.controller;

import com.amazonaws.services.s3.model.ObjectListing;
import com.tresmigos.fullstackvideo.model.Account;
import com.tresmigos.fullstackvideo.model.Video;
import com.tresmigos.fullstackvideo.service.AccountService;
import com.tresmigos.fullstackvideo.service.AwsServiceClient;
import com.tresmigos.fullstackvideo.service.VideoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class VideoControllerTest {
    @Autowired
    MockMvc mockMvc;

    @InjectMocks
    VideoController videoController;

    @Mock
    VideoService service;


    private List<Video> videoList;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(videoController).build();

    }

    @Test
    void read() throws Exception {
        //given
        Video video = new Video();
        ResponseEntity<Video> expected = new ResponseEntity<>(video,HttpStatus.OK);

        //when
        Mockito.doReturn(video).when(service).read(Mockito.anyLong());

        //then
        mockMvc.perform(get("/video/getVideo/{id}",5L)).andExpect(status().isOk());
    }

    @Test
    void readAll() throws Exception {
        //given
        List<Video> videoList = new ArrayList<>();
        ResponseEntity<List<Video>> expected = new ResponseEntity<>(videoList,HttpStatus.OK);

        //when
        Mockito.doReturn(videoList).when(service).readAll();
        //then
        mockMvc.perform(get("/video/all",5L)).andExpect(status().isOk());

    }

//    @Test
//    void create() throws Exception {
//        //given
//        Account account = new Account();
//        ResponseEntity<Account> expected = new ResponseEntity<>(account,HttpStatus.CREATED);
//
//        //when
//        Mockito.doReturn(account).when(service).create(account);
//
////        //Then
////        assertEquals(expected,actual);
//        mockMvc.perform(post("/create",5L)).andExpect(status().isOk());
//
//    }
//
//    @Test
//    void updateTest() {
//        //given
//        Account account = new Account();
//        ResponseEntity<Account> expected = new ResponseEntity<>(account,HttpStatus.OK);
//
//        //when
//        Mockito.when(service.update(5L, account)).thenReturn(account);
//
//        ResponseEntity<Account> actual = accountController.update(5L,account);
//
//        //Then
//        assertEquals(expected,actual);
//    }
//
//    @Test
//    void delete() {
//        //given
//        Account account = new Account();
//        ResponseEntity<Account> expected = new ResponseEntity<>(account,HttpStatus.OK);
//
//        //when
//        Mockito.doReturn(account).when(service).delete(Mockito.anyLong());
//        ResponseEntity<Account> actual = accountController.delete(Mockito.anyLong());
//
//        //Then
//        assertEquals(expected,actual);
//    }
}