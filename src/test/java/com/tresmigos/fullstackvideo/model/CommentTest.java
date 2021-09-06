package com.tresmigos.fullstackvideo.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CommentTest {
    @InjectMocks
    Comment comment;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getCommentId() {
        //given
        Long expectedId=5L;
        comment.setCommentId(5L);
        //when
        Long actual= comment.getCommentId();
        //then
        assertEquals(expectedId,actual);
    }

    @Test
    void getText() {
        //given
        String expected="great video";
        comment.setText(expected);
        //when
        String actual=comment.getText();
        //then
        assertEquals(expected,actual);
    }

    @Test
    void getDatePosted() throws IllegalArgumentException{
        //given
        Date expected=new Date();
        comment.setDatePosted(expected);
        //when
        Date actual=comment.getDatePosted();
        //then
        assertEquals(expected,actual);
    }
}