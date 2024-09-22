package com.example.demo.Repository;

import com.example.demo.Entity.AccountData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransferMoneyRepository extends MongoRepository<AccountData, String> {
    AccountData findByAccountid(String accountid);

}
