package com.tresmigos.fullstackvideo.controller;

import com.google.gson.Gson;
import com.tresmigos.fullstackvideo.model.Account;
import com.tresmigos.fullstackvideo.model.Comment;
import com.tresmigos.fullstackvideo.service.AccountService;
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

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AccountControllerTest {
    @Autowired
    MockMvc mockMvc;

    @InjectMocks
    AccountController accountController;

    @Mock
    AccountService service;

    private Gson gson;

    AccountControllerTest() {
    }


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(accountController).build();
        gson = new Gson();

    }

    @Test
    void read() throws Exception {

        Account account = new Account();

        Mockito.doReturn(account).when(service).read(Mockito.anyLong());

        mockMvc.perform(get("/account/read{id}",5L)).andExpect(status().isOk());
    }

    @Test
    void readAll() throws Exception {

        List<Comment> accountList = new ArrayList<>();

        Mockito.doReturn(accountList).when(service).readAll();

        mockMvc.perform(get("/account/readAll",5L)).andExpect(status().isOk());

    }

    @Test
    void create() throws Exception {

        Account account = new Account();

        Mockito.doReturn(account).when(service).create(account);

        mockMvc.perform(post("/account/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(account)))
                .andExpect(status().isCreated());
    }

    @Test
    void updateTest() throws Exception {

        Account account = new Account();

        Mockito.when(service.update(5L, account)).thenReturn(account);


        mockMvc.perform(put("/account/update/{id}",5L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(account)))
                .andExpect(status().isOk());
    }

    @Test
    void deleteTest() throws Exception {

        Account account = new Account();
//
        Mockito.doReturn(account).when(service).delete(Mockito.anyLong());

        mockMvc.perform(delete("/account/delete/{id}", 5L))
                .andExpect(status().isOk());

    }
}