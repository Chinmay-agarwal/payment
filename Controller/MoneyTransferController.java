package com.example.demo.Controller;

import com.example.demo.DTO.TransferMoney;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.demo.Services.moneyTransferService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class MoneyTransferController {

    @Autowired
    private final moneyTransferService moneytransferService;
    public MoneyTransferController(moneyTransferService moneytransferService) {
        this.moneytransferService = moneytransferService;
    }

    @PostMapping("/transfer_money")
    public ResponseEntity<?> transfer_money(@Valid @RequestBody TransferMoney transferMoney) {
        return moneytransferService.transferMoney(transferMoney);
    }
}
