package com.tresmigos.fullstackvideo.service;

import com.tresmigos.fullstackvideo.model.Account;
import com.tresmigos.fullstackvideo.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;

class AccountServiceTest {
    @InjectMocks
    AccountService accountService;

    @Mock
    AccountRepository repository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void create() {
        //given
        Account account=new Account();
        Account expected=new Account();
        //when
        Mockito.doReturn(expected).when(repository).save(account);
        Account actual=accountService.create(account);
        //then
        assertEquals(expected,actual);
    }

    @Test
    void read() {
        //given
        List<Long> id = new ArrayList<>();
        Account account = new Account();
        Account expected = new Account();

        //when
        when(repository.findById(anyLong())).thenReturn(Optional.of(expected));
        Account Actual =accountService.read(anyLong());

        //Then
        assertEquals(expected,Actual);
    }

    @Test
    void readAll() {
        //given
        Account account = new Account();
        List<Account> result = new ArrayList<>();
        result.add(new Account());
        List expected = new ArrayList();

        //when
        Mockito.doReturn(expected).when(repository).findAll();
        List Actual = accountService.readAll();

        //Then
        assertEquals(expected,Actual);
    }

    @Test
    void update() {
        //given
        List<Long> id = new ArrayList<>();
        id.add(5L);
        id.add(6L);
        Account account = new Account();
        account.setAccountId(5L);
        account.setUsername("Mark");
        account.setPassword("Finland");


        //when
        when(repository.findById(anyLong())).thenReturn(Optional.of(account));
        when(repository.save(account)).thenReturn(account);

        Account actual = accountService.update(anyLong(),account);

        //Then
        assertEquals(account,actual);
    }

    @Test
    void delete() {
        //given
        Account account = new Account();

        //when
        Mockito.when(repository.findById(2L)).thenReturn(Optional.of(account));
        Account actual = accountService.delete(2L);

        //Then
        assertEquals(account,actual);
    }

    @Test
    void testDelete() {
        //given
        Account account = new Account();

        //when
        Mockito.when(repository.findById(4L)).thenReturn(Optional.of(account));
        Account actual = accountService.delete(4L);

        //Then
        assertEquals(account,actual);
    }

    @Test
    void login(){
        //given
        Account account=new Account();
        Account expected=new Account();
        //when
        Mockito.doReturn(expected).when(repository)
                .findByUsernameAndPassword("leon","hunter");
        Account actual=accountService.login("leon","hunter");
        //then
        assertEquals(expected,actual);
    }
}