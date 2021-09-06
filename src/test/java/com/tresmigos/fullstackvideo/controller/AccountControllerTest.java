package com.tresmigos.fullstackvideo.controller;

import com.tresmigos.fullstackvideo.model.Account;
import com.tresmigos.fullstackvideo.service.AccountService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
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

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class AccountControllerTest {
    @Autowired
    MockMvc mockMvc;

    @InjectMocks
    AccountController accountController;

    @Mock
    AccountService service;


    private List<Account> accountList;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(accountController).build();

    }

    @Test
    void read() throws Exception {
        //given
        Account account = new Account();
        ResponseEntity<Account> expected = new ResponseEntity<>(account,HttpStatus.OK);

        //when
        Mockito.doReturn(account).when(service).read(Mockito.anyLong());

        //then
        mockMvc.perform(get("/account/read/{id}",5L)).andExpect(status().isOk());
    }

    @Test
    void readAll() throws Exception {
        //given
        List<Account> accountList = new ArrayList<>();
        ResponseEntity<List<Account>> expected = new ResponseEntity<>(accountList,HttpStatus.OK);

        //when
        Mockito.doReturn(accountList).when(service).readAll();
        //then
        mockMvc.perform(get("/readAll",5L)).andExpect(status().isOk());

    }

    @Test
    void create() throws Exception {
        //given
        Account account = new Account();
        ResponseEntity<Account> expected = new ResponseEntity<>(account,HttpStatus.CREATED);

        //when
        Mockito.doReturn(account).when(service).create(account);

//        //Then
//        assertEquals(expected,actual);
        mockMvc.perform(post("/create",5L)).andExpect(status().isOk());

    }

    @Test
    void updateTest() {
        //given
        Account account = new Account();
        ResponseEntity<Account> expected = new ResponseEntity<>(account,HttpStatus.OK);

        //when
        Mockito.when(service.update(5L, account)).thenReturn(account);

        ResponseEntity<Account> actual = accountController.update(5L,account);

        //Then
        assertEquals(expected,actual);
    }

    @Test
    void delete() {
        //given
        Account account = new Account();
        ResponseEntity<Account> expected = new ResponseEntity<>(account,HttpStatus.OK);

        //when
        Mockito.doReturn(account).when(service).delete(Mockito.anyLong());
        ResponseEntity<Account> actual = accountController.delete(Mockito.anyLong());

        //Then
        assertEquals(expected,actual);
    }
}