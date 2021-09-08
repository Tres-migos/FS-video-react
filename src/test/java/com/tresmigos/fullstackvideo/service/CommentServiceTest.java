package com.tresmigos.fullstackvideo.service;

import com.tresmigos.fullstackvideo.model.Comment;
import com.tresmigos.fullstackvideo.repository.CommentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;

class CommentServiceTest {

    @InjectMocks
    CommentService commentService;

    @Mock
    CommentRepository repository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void create() {
        //given
        Comment comment=new Comment();
        Comment expected=new Comment();
        //when
        Mockito.doReturn(expected).when(repository).save(comment);
        Comment actual=commentService.create(comment);
        //then
        assertEquals(expected,actual);
    }

    @Test
    void read() {
        //given
        List<Long> id = new ArrayList<>();
        Comment comment = new Comment();
        Comment expected = new Comment();

        //when
        when(repository.findById(anyLong())).thenReturn(Optional.of(expected));
        Comment actual =commentService.read(anyLong());

        //Then
        assertEquals(expected,actual);
    }

    @Test
    void readAll() {
        //given
        Comment comment = new Comment();
        List<Comment> result = new ArrayList<>();
        result.add(new Comment());
        List expected = new ArrayList();

        //when
        Mockito.doReturn(expected).when(repository).findAll();
        List Actual = commentService.readAll();

        //Then
        assertEquals(expected,Actual);
    }

    @Test
    void update() {
        //given
        List<Long> id = new ArrayList<>();
        id.add(5L);
        id.add(6L);
        Comment comment = new Comment();
        comment.setText("good video");
        comment.setDatePosted(new Date());


        //when
        when(repository.findById(anyLong())).thenReturn(Optional.of(comment));
        when(repository.save(comment)).thenReturn(comment);

        Comment actual = commentService.update(anyLong(),comment);

        //Then
        assertEquals(comment,actual);
    }

    @Test
    void delete() {
        //given
        Comment comment = new Comment();

        //when
        Mockito.when(repository.findById(2L)).thenReturn(Optional.of(comment));
        Comment actual = commentService.delete(2L);

        //Then
        assertEquals(comment,actual);
    }

    @Test
    void testDelete() {
        //given
        Comment comment = new Comment();

        //when
        Mockito.when(repository.findById(4L)).thenReturn(Optional.of(comment));
        Comment actual = commentService.delete(4L);

        //Then
        assertEquals(comment,actual);
    }
}