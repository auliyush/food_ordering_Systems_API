package com.example.demo.Service.ServiceImpl;

import com.example.demo.Component.HelperClassForValidation;
import com.example.demo.Model.ModelRequest.UserRequest;
import com.example.demo.Model.ModelUPdateRequest.UserUpdateRequest;
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
        ;
        if(userRepository.findByUserEmail(userRequest.getUserEmail()) == null){
            User user = new User();
            user.setUserName(HelperClassForValidation.trimmedMethod(userRequest.getUserName()));
            user.setUserPassword(HelperClassForValidation.trimmedMethod(userRequest.getUserPassword()));
            if(!HelperClassForValidation.validatePassword(user.getUserPassword())){
                return new User();
            }
            user.setUserEmail(HelperClassForValidation.trimmedMethod(userRequest.getUserEmail()));
            if(!HelperClassForValidation.validateEmail(user.getUserEmail())){
                return new User();
            }
            user.setUserRole(HelperClassForValidation.trimmedMethod(userRequest.getUserRole()));
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
    public User updateProfile(UserUpdateRequest userUpdateRequest) {
        Optional<User> optionalUser = userRepository.findById(userUpdateRequest.getUserId());
        User user = userRepository.findByUserEmail(optionalUser.get().getUserEmail());
        if (optionalUser.isPresent()) {
            if (userUpdateRequest.getUserName() != null){
                optionalUser.get().setUserName(userUpdateRequest.getUserName());
            }
            if (userUpdateRequest.getUserEmail() != null){
                optionalUser.get().setUserEmail(userUpdateRequest.getUserEmail());
            }
            if (userUpdateRequest.getUserPassword() != null){
                optionalUser.get().setUserPassword(userUpdateRequest.getUserPassword());
            }

            System.out.println("chut"+optionalUser.get().getUserEmail());
            return userRepository.save(user);
        }
        return new User();
    }

    @Override
    public Optional<User> findById(Integer userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            return user;
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<User> getListOfUsers() {
        return userRepository.findAll();
    }
}