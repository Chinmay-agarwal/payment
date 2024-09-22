package com.example.demo.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class AddAccount {
    @Id
    private String accountid;
    @NotBlank
    private String name;
    @NotBlank
    private String email;
    @NotBlank
    @Pattern(regexp = "^[0-9]*$")
    @Size(min = 10, max = 10)
    private String phone;
    @NotBlank
    private String accountName;


    private int pin;
}
//ismein kya likhu aise hi kehne pe account add kardu kya jab bank se connect nhi hona toh