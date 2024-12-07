package com.example.demo.Service;

import com.example.demo.Model.ModelRequest.UserRequest;
import com.example.demo.Model.ModelUPdateRequest.UserUpdateRequest;
import com.example.demo.Model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User signUp(UserRequest userRequest);

    List<User> getListOfUsers();

    User signIn(String userEmail, String userPassword);

    Optional<User> findById(Integer userId);

    User updateProfile(UserUpdateRequest userUpdateRequest);
}