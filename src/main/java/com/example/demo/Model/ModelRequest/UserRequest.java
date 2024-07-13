package com.example.demo.Model.ModelRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserRequest {
    private String userName;
    private String userPassword;
    private String userEmail;
    private String userRole;
}
