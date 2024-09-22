package com.example.demo.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TransferMoney {
    @NotBlank
    private String from;// the frontend will send the accountid of the user who is sending the money
    @NotBlank
    private String to;

    private double amount;
    private String remarks;

    private int pin;
}
