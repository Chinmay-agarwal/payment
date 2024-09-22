package com.example.demo.Response;

import lombok.Data;

import java.util.List;

@Data
public class StartPageData {
    private List<String> accounts;// list of all existing accounts linked to this id
    private String UserName;
    private String email;
    private String phone;


}
