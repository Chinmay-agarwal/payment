package com.example.demo.Controller;


import com.example.demo.DTO.Login;
import com.example.demo.DTO.Register;
import com.example.demo.Services.AccountServices;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {
    private final AccountServices accountService;
    public AccountController(AccountServices accountService) {
        this.accountService = accountService;
    }


    @PostMapping("/register_account")
    public ResponseEntity<?> register_account(@Valid @RequestBody Register register) {
        return accountService.registerAccount(register);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login_account(@Valid @RequestBody Login login) {
        return accountService.loginAccount(login);
    }




}
