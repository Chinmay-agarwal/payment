package com.example.demo.Services;

import com.example.demo.DTO.FindAccount;
import com.example.demo.Entity.AccountData;
import com.example.demo.Repository.BankAccountRepository;
import com.example.demo.Response.Accountdetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {
    @Autowired
    private final BankAccountRepository bankAccountRepository;

    public SearchService(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    public ResponseEntity<?> search(FindAccount findAccount) {
        String phone = findAccount.getPhone();
        String email = findAccount.getEmail();

        if (phone != null) {
            if (isValidPhoneNumber(phone)) {
                List<AccountData> accounts = bankAccountRepository.findAllByPhone(phone);
                if (accounts.isEmpty()) {
                    return ResponseEntity.badRequest().body("No accounts found for this phone number.");
                }
                return ResponseEntity.ok(accounts); // Return the list of accounts
            } else {
                return ResponseEntity.badRequest().body("Invalid phone number.");
            }
        } else if (email != null) {
            if (!isValidEmail(email)) {
                return ResponseEntity.badRequest().body("Invalid email.");
            }
            List<AccountData> accounts = bankAccountRepository.findAllByEmail(email);
            if (accounts.isEmpty()) {
                return ResponseEntity.badRequest().body("No accounts found for this email.");
            }
            return ResponseEntity.ok(accounts); // Return the list of accounts
        }

        return ResponseEntity.badRequest().body("Account doesn't exist.");
    }


    private boolean isValidEmail(String identifier) {
        return identifier.contains("@") && identifier.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    private boolean isValidPhoneNumber(String identifier) {
        return identifier.matches("\\d{10}");
    }
}
