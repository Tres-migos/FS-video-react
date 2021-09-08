package com.tresmigos.fullstackvideo.controller;


import com.tresmigos.fullstackvideo.model.Comment;
import com.tresmigos.fullstackvideo.service.CommentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CommentControllerTest {
    @Autowired
    MockMvc mockMvc;

    @InjectMocks
    CommentController commentController;

    @Mock
    CommentService service;

    private Gson gson;

    CommentControllerTest() {
    }


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(commentController).build();
        gson = new Gson();

    }

    @Test
    void read() throws Exception {

        Comment comment = new Comment();

        Mockito.doReturn(comment).when(service).read(Mockito.anyLong());

        mockMvc.perform(get("/comment/{id}",5L)).andExpect(status().isOk());
    }

    @Test
    void readAll() throws Exception {

        List<Comment> commentList = new ArrayList<>();

        Mockito.doReturn(commentList).when(service).readAll();

        mockMvc.perform(get("/comment/allComment",5L)).andExpect(status().isOk());

    }

    @Test
    void create() throws Exception {

        Comment comment = new Comment();

        Mockito.doReturn(comment).when(service).create(comment);

        mockMvc.perform(post("/comment/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(comment)))
                .andExpect(status().isCreated());
    }

    @Test
    void updateTest() throws Exception {

        Comment comment = new Comment();

        Mockito.when(service.update(5L, comment)).thenReturn(comment);


        mockMvc.perform(put("/comment/update/{id}",5L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(comment)))
                .andExpect(status().isOk());
    }

    @Test
    void deleteTest() throws Exception {

        Comment comment = new Comment();
//
        Mockito.doReturn(comment).when(service).delete(Mockito.anyLong());

        mockMvc.perform(delete("/comment/delete/{id}", 5L))
                .andExpect(status().isOk());

    }
}