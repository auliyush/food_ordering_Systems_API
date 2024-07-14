package com.example.demo.Controller;

import com.example.demo.Model.ModelRequest.UserRequest;
import com.example.demo.Model.ModelUPdateRequest.UserUpdateRequest;
import com.example.demo.Model.User;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signUp")
    public User signUp(@RequestBody UserRequest userRequest) {
        return userService.signUp(userRequest);
    }

    @GetMapping("/signIn")
    public User signIn(@RequestParam String userEmail, String userPassword) {
        return userService.signIn(userEmail, userPassword);
    }
    @PutMapping("/profile/update")
    public User updateProfile(@RequestBody UserUpdateRequest userUpdateRequest){
        return userService.updateProfile(userUpdateRequest);
    }
    @GetMapping("/view/Profile")
    public Optional<User> viewProfile(@RequestParam Integer userId) {
        return userService.findById(userId);
    }

    @GetMapping("/list/of/users")
    public List<User> getListOfUsers() {
        return userService.getListOfUsers();
    }
}