package com.example.demo.Services;

import com.example.demo.DTO.AddAccount;
import com.example.demo.Entity.AccountData;
import com.example.demo.Repository.BankAccountRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class AddAccountService {
    private final BankAccountRepository bankAccountRepository;

    public AddAccountService(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    public ResponseEntity<?> addAccountNew(AddAccount addAccount) {
        if(bankAccountRepository.existsByAccountName(addAccount.getAccountName())) {
            return ResponseEntity.ok("Account already exists");
        }

        AccountData accountData = new AccountData(addAccount.getEmail(),addAccount.getPhone(),
                10000.00,addAccount.getPin(),addAccount.getAccountName(),
                addAccount.getName(),"Active", LocalDate.now().format(DateTimeFormatter.ISO_DATE)
                ,LocalDate.now().format(DateTimeFormatter.ISO_DATE),
                LocalDate.now().format(DateTimeFormatter.ISO_DATE),null);
        return ResponseEntity.ok(bankAccountRepository.save(accountData));
    }
}
