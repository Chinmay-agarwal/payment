package com.example.demo.Services;

import com.example.demo.DTO.TransferMoney;
import com.example.demo.Entity.AccountData;
import com.example.demo.Entity.TransactionData;
import com.example.demo.Repository.TransferMoneyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class moneyTransferService {

    @Autowired
    private final TransferMoneyRepository transferMoneyRepository;
    public moneyTransferService(TransferMoneyRepository transferMoneyRepository) {
        this.transferMoneyRepository = transferMoneyRepository;
    }

    public ResponseEntity<?> transferMoney(TransferMoney transferMoney) {
        AccountData accountData_sender = transferMoneyRepository.findByAccountid(transferMoney.getFrom());
        AccountData accountData_receiver = transferMoneyRepository.findByAccountid(transferMoney.getTo());
        if(accountData_sender.getPin()!=transferMoney.getPin()) {
            return ResponseEntity.ok("Invalid pin");
        }
        if(accountData_sender.getBalance()<transferMoney.getAmount()) {
            List<TransactionData> transactionHistory= accountData_sender.getAccountTransactionHistory();

            if(transactionHistory==null) {
                transactionHistory = new ArrayList<>();
            }
            transactionHistory.add(new TransactionData(
                    transferMoney.getFrom(),
                    transferMoney.getTo(),
                    LocalDate.now().format(DateTimeFormatter.ISO_DATE),
                    LocalTime.now().format(DateTimeFormatter.ISO_TIME),
                    transferMoney.getAmount(),
                    "Failed",
                    transferMoney.getRemarks(),
                    "Transfer"
            ));

            accountData_sender.setAccountTransactionHistory(transactionHistory);

            transferMoneyRepository.save(accountData_sender);
            return ResponseEntity.ok("Insufficient balance");
        }
        accountData_sender.setBalance(accountData_sender.getBalance()-transferMoney.getAmount());
        accountData_receiver.setBalance(accountData_receiver.getBalance()+transferMoney.getAmount());
        transferMoneyRepository.save(accountData_sender);
        transferMoneyRepository.save(accountData_receiver);

        List<TransactionData> transactionHistory= accountData_sender.getAccountTransactionHistory();

        if(transactionHistory==null) {
            transactionHistory = new ArrayList<>();
        }

        transactionHistory.add(new TransactionData(
                transferMoney.getFrom(),
                transferMoney.getTo(),
                LocalDate.now().format(DateTimeFormatter.ISO_DATE),
                LocalTime.now().format(DateTimeFormatter.ISO_TIME),
                transferMoney.getAmount(),
                "Success",
                transferMoney.getRemarks(),
                "Transfer"
        ));

        accountData_sender.setAccountTransactionHistory(transactionHistory);

        transferMoneyRepository.save(accountData_sender);

        List<TransactionData> transactionHistory_receiver = accountData_receiver.getAccountTransactionHistory();

        if(transactionHistory_receiver==null) {
            transactionHistory_receiver = new ArrayList<>();
        }

        transactionHistory_receiver.add(new TransactionData(
                transferMoney.getFrom(),
                transferMoney.getTo(),
                LocalDate.now().format(DateTimeFormatter.ISO_DATE),
                LocalTime.now().format(DateTimeFormatter.ISO_TIME),
                transferMoney.getAmount(),
                "Success",
                transferMoney.getRemarks(),
                "Received"
        ));

        accountData_receiver.setAccountTransactionHistory(transactionHistory_receiver);

        transferMoneyRepository.save(accountData_receiver);


        return ResponseEntity.ok("Transaction successful");
    }


}
