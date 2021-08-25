package com.tresmigos.fullstackvideo.repository;

import com.tresmigos.fullstackvideo.model.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account,Long> {
}
