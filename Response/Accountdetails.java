package com.example.demo.Response;

import lombok.Data;

@Data
public class Accountdetails {
    private double balance;
    //private List<TransactionData> accountTransactionHistory; give when asks for transaction history
    private String accountHolderName;
    private String accountStatus;
    private String accountCreationDate;
}
