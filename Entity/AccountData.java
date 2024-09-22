package com.example.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountData {
    @Id
    private String accountid;
    
    private String email;
    private String phone;
    private double balance;
    private int pin;
    private String accountName;
    private String accountHolderName;
    private String accountStatus;
    private String accountCreationDate;
    private String accountLastUpdated;
    private String accountLastAccessed;
    @Setter
    private List<TransactionData> accountTransactionHistory;

    public AccountData(String email, String phone, double balance, int pin, String accountName, String accountHolderName, String accountStatus, String accountCreationDate, String accountLastUpdated, String accountLastAccessed, List<TransactionData> accountTransactionHistory) {
        this.email = email;
        this.phone = phone;
        this.balance = balance;
        this.pin = pin;
        this.accountName = accountName;
        this.accountHolderName = accountHolderName;
        this.accountStatus = accountStatus;
        this.accountCreationDate = accountCreationDate;
        this.accountLastUpdated = accountLastUpdated;
        this.accountLastAccessed = accountLastAccessed;
        this.accountTransactionHistory = accountTransactionHistory;
    }

}
