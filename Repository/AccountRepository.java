package com.example.demo.Repository;

import com.example.demo.Entity.UserData;
import org.springframework.data.mongodb.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends MongoRepository<UserData,String> {

    boolean  existsByEmail(String email);
    boolean  existsByPhone(String phone);

    UserData findByEmail(String email);
    UserData findByPhone(String phone);



}
