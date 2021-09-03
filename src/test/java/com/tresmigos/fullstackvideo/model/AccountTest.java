package com.tresmigos.fullstackvideo.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @InjectMocks
    Account account;

    @Mock
    Video video;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getId() {
        //given
        Long expectedId=5L;
        account.setAccountId(5L);
        //when
        Long actual=account.getAccountId();
        //then
        assertEquals(expectedId,actual);
    }

    @Test
    void getUsername() {
        //given
        String expected="Mark";
        account.setUsername(expected);
        //when
        String actual=account.getUsername();
        //then
        assertEquals(expected,actual);
    }

    @Test
    void getPassword() {
        //given
        String expected="finland";
        account.setPassword(expected);
        //when
        String actual=account.getPassword();
        //then
        assertEquals(expected,actual);
    }

    @Test
    void getVideos() {
        //given
        Video v1=new Video();
        Video v2=new Video();
        Set<Video> expected = new HashSet<>();
        expected.add(v1);
        expected.add(v2);
        account.setVideos(expected);

        //when
        Set<Video> actual=account.getVideos();
        //then
        assertEquals(expected,actual);
    }
}