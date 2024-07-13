package com.example.demo.Service.ServiceImpl;

import com.example.demo.Model.ModelRequest.UserRequest;
import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User signUp(UserRequest userRequest) {
        if(userRepository.findByUserEmail(userRequest.getUserEmail()) == null){
            User user = new User();
            user.setUserName(userRequest.getUserName());
            user.setUserPassword(userRequest.getUserPassword());
            user.setUserEmail(userRequest.getUserEmail());
            user.setUserRole(userRequest.getUserRole());
            return userRepository.save(user);
        }else {
            return new User();
        }
    }

    @Override
    public User signIn(String userEmail, String userPassword) {
        User user = userRepository.findByUserEmail(userEmail);
        if(user == null){
            return new User();
        }else{
            if(user.getUserPassword().equals(userPassword)){
                return user;
            }else{
                return new User();
            }
        }
    }

    @Override
    public Optional<User> findById(Integer userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            return user;
        } else {
            return Optional.of(new User());
        }
    }

    @Override
    public List<User> getListOfUsers() {
        return userRepository.findAll();
    }
}