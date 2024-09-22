package com.example.demo.Controller;
import com.example.demo.DTO.AddAccount;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

import com.example.demo.Services.AddAccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddAccountController {
    private final AddAccountService addAccountService;
    public AddAccountController(AddAccountService addAccountService) {
        this.addAccountService = addAccountService;
    }

    @PostMapping("/add_account")
    public ResponseEntity<?> add_account(@Valid @RequestBody AddAccount addAccount) {
        return addAccountService.addAccountNew(addAccount);
    }
}
