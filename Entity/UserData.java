package com.example.demo.Entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

//jo bhi data store hoga db mein user ka wo yaha store hoga
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserData {
    @Id
    private String id;
    private String name;
    private String password;
    private String email;
    private String phone;

    private List<String> accountid;

    public UserData(String password, String email, String phone, String name) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.phone = phone;

    }


}
