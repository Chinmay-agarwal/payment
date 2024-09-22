package com.example.demo.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

//yeh wo sara data hai jo register karte waqt user se mila from frontend
@Data
public class Register {
    @NotBlank
    private String username;
    @NotBlank

    private String password;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Pattern(regexp = "^[0-9]*$")
    @Size(min = 10, max = 10)
    private String phone;

}
