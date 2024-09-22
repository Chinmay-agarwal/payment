package com.example.demo.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class FindAccount {
    @Email
    private String email;
    @Pattern(regexp = "^[0-9]*$")
    @Size(min = 10, max = 10)
    private String phone;
}
