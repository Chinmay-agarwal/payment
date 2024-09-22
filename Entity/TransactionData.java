package com.example.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

//for each and every transaction
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TransactionData {
    @Id
    private String id;

    private String accountLastTransactionFrom;
    private String accountLastTransactionTo;
    private String accountLastTransactionDate;
    private String accountLastTransactionTime;
    private double accountLastTransactionAmount;
    private String accountLastTransactionStatus;
    private String accountLastTransactionRemarks;
    private String type;

    public TransactionData(String accountLastTransactionFrom, String accountLastTransactionTo, String accountLastTransactionDate, String accountLastTransactionTime, double accountLastTransactionAmount, String accountLastTransactionStatus, String accountLastTransactionRemarks, String type) {
        this.accountLastTransactionFrom = accountLastTransactionFrom;
        this.accountLastTransactionTo = accountLastTransactionTo;
        this.accountLastTransactionDate = accountLastTransactionDate;
        this.accountLastTransactionTime = accountLastTransactionTime;
        this.accountLastTransactionAmount = accountLastTransactionAmount;
        this.accountLastTransactionStatus = accountLastTransactionStatus;
        this.accountLastTransactionRemarks = accountLastTransactionRemarks;
        this.type = type;
    }
}
