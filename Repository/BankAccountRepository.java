package com.example.demo.Repository;

import com.example.demo.Entity.AccountData;
import org.springframework.data.mongodb.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankAccountRepository extends MongoRepository<AccountData, String> {
    AccountData findByAccountid(String accountid);
    List<AccountData> findAllByEmail(String email);
    List<AccountData> findAllByPhone(String phone);
    boolean existsByAccountName(String accountName);
    boolean existsByEmail(String email);
    boolean existsByPhone(String phone);
    boolean existsByAccountid(String accountid);
    void deleteByAccountid(String accountid);
}
