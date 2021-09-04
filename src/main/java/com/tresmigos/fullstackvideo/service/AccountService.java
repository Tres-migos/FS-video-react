package com.tresmigos.fullstackvideo.service;

import com.tresmigos.fullstackvideo.model.Account;
import com.tresmigos.fullstackvideo.repository.AccountRepository;
import com.tresmigos.fullstackvideo.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    private VideoRepository videoRepository;
    @Autowired
    private AccountRepository accountRepository;

    public Account create(Account account){
        return accountRepository.save(account);
    }

    public Account read(Long id){
        return accountRepository.findById(id).orElse(null);
    }

    public List<Account> readAll(){
        Iterable<Account> accountIterable = accountRepository.findAll();
        List<Account> result = new ArrayList<>();
        accountIterable.forEach(result :: add);
        for(Account account: result){
            account.setVideos(videoRepository.findByUser(account.getId()));
        }
        return  result;
    }

    public Account update(Long id, Account newAccountData){
        Account accountInDb = read(id);
        accountInDb.setUsername(newAccountData.getUsername());
        accountInDb.setPassword(newAccountData.getPassword());
        return  accountRepository.save(accountInDb);
    }

    public Account delete(Long id){
        Account accountInDb = read(id);
        accountRepository.deleteById(id);
        return accountInDb;
    }

    public Account delete(Account account){
        return delete(account.getId());
    }
}
