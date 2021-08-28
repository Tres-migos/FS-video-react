package com.tresmigos.fullstackvideo.account;

import com.tresmigos.fullstackvideo.account.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account,Long> {
}
