package com.example.demo.Component;

import java.util.regex.Pattern;

public class HelperClassForValidation {

   static public String trimmedMethod(String str){
        return str.trim();
    }

    static public String validateUserName(String username) {
        int specialCharacterCount = 0;
        int characterCount =  0;
        for(char ch : username.toCharArray()){
            if(ch >= 32 && ch <= 47 || ch >= 58 && ch <= 64 || ch >= 91 && ch <= 96 || ch >= 123 && ch <= 126){
                specialCharacterCount++;
            }
            characterCount++;
        }
        if(specialCharacterCount == 0){
            return "please enter atleast one special character %$#@";
        }
        if(characterCount < 5){
            return "Username should be must five character";
        }
        return "valid";
    }

    static public boolean validateEmail(String userEmail) {
        if(userEmail == null || userEmail.isEmpty()){
            return false;
        }
        String userEmailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+.)+[a-zA-Z]{2,7}";
        Pattern pattern = Pattern.compile(userEmailRegex);
        if(pattern.matcher(userEmail).matches()){
            return true;
        }else{
            return false;
        }
    }

    static public boolean validatePassword(String userPassword) {
        if (userPassword == null || userPassword.isEmpty()){
            return false;
        }
        int specialCharacterCount = 0;
        int characterCount =  0;
        for(char ch : userPassword.toCharArray()){
            if(ch >= 32 && ch <= 64 || ch >= 91 && ch <= 96 || ch >= 123 && ch <= 126){
                specialCharacterCount++;
            }
            characterCount++;
        }
        if(specialCharacterCount == 0){
            return false;
        }
        if(characterCount < 3){
            return false;
        }
        return true;
    }

    static public boolean validatePhoneNUmber(String userPhoneNumber) {
        int lengthOfUserPhoneNumber = userPhoneNumber.length();
        boolean checkValue;
        try {
            Double.parseDouble(userPhoneNumber);
            checkValue = true;
        } catch (NumberFormatException e) {
            checkValue = false;
        }
        if (!checkValue) {
            return false;
        } else if (lengthOfUserPhoneNumber != 10) {
            return false;
        } else {
            return true;
        }

    }
    public boolean validateName(String name) {
        if(name.isEmpty() || name.equals(null)){
            return false;
        }else {
            return true;
        }
    }
}


