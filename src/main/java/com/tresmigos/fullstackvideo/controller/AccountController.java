package com.tresmigos.fullstackvideo.controller;

import com.tresmigos.fullstackvideo.model.Account;
import com.tresmigos.fullstackvideo.repository.AccountRepository;
import com.tresmigos.fullstackvideo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/account-controller")
public class AccountController {
    private AccountRepository accountRepository;

    @Autowired
    AccountService accountService;


    public AccountController(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @PostMapping(value = "/createAcc")
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        return new ResponseEntity<>(accountService.create(account), HttpStatus.CREATED);

    }

    @GetMapping(value = "/read/{id}")
    public ResponseEntity<Account> read(@PathVariable Long id){
        return new ResponseEntity<>(accountService.read(id), HttpStatus.OK);
    }

    @GetMapping(value = "/readAll")
    public ResponseEntity<List<Account>> readAll(){
        return new ResponseEntity<>(accountService.readAll(), HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Account> update(@PathVariable Long id, @RequestBody Account newAccountData){
        return new ResponseEntity<>(accountService.update(id, newAccountData), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Account> delete(@PathVariable Long id){
        return new ResponseEntity<>(accountService.delete(id), HttpStatus.NO_CONTENT);
    }

}
