package com.example.springsecurityrolepermission.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTO {
    private String fullName;
    private String userName;
    private String password;
    private String prepassword;
}
