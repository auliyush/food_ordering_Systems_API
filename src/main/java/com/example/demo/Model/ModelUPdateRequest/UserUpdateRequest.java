package com.example.demo.Model.ModelUPdateRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserUpdateRequest {
    private Integer userId;
    private String userName;
    private String userPassword;
    private String userEmail;
}
