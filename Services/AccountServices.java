package com.example.demo.Services;

import com.example.demo.DTO.Login;
import com.example.demo.DTO.Register;
import com.example.demo.Entity.UserData;
import com.example.demo.Repository.AccountRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class AccountServices {
    private final AccountRepository accountRepository;
    public AccountServices(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public ResponseEntity<?> registerAccount(Register register) {
        boolean exists = accountRepository.existsByEmail(register.getEmail());
        boolean exists_phone = accountRepository.existsByPhone(register.getPhone());
        if(register.getUsername() == null || register.getPassword() == null || register.getEmail() == null || register.getPhone() == null) {
            return ResponseEntity.badRequest().body("All fields are required.");
        }
        if(exists) {
            return ResponseEntity.ok("Email already exists");
        }

        if(exists_phone) {
            return ResponseEntity.ok("Phone number already exists");
        }

        UserData userdata = new UserData( register.getPassword(), register.getEmail(), register.getPhone(), register.getUsername());
        accountRepository.save(userdata);


        return ResponseEntity.ok("User registered successfully");
    }

    public ResponseEntity<?> loginAccount(Login login) {
        String identifier = login.getLoginIdentifier();
        String password = login.getPassword();

        if (identifier == null ) {
            return ResponseEntity.badRequest().body("Email id or phone number is required.");
        }
        if(isValidEmail(identifier)) {
            UserData userData = accountRepository.findByEmail(identifier);
            if(userData == null) {
                return ResponseEntity.badRequest().body("User not found.");
            }
            if(userData.getPassword().equals(password)) {
                return ResponseEntity.ok("Login successful");
            }
            return ResponseEntity.badRequest().body("Invalid password.");
        }
        if(isValidPhoneNumber(identifier)) {
            UserData userData = accountRepository.findByPhone(identifier);
            if(userData == null) {
                return ResponseEntity.badRequest().body("User not found.");
            }
            if(userData.getPassword().equals(password)) {
                return ResponseEntity.ok("Login successful");
            }
            return ResponseEntity.badRequest().body("Invalid password.");
        }

        return ResponseEntity.badRequest().body("Invalid email id or phone number.");

    }

    private boolean isValidEmail(  String identifier ) {
        return identifier.contains("@") && identifier.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    private boolean isValidPhoneNumber(String identifier) {
        return identifier.matches("\\d{10}");
    }


}
