package org.example.userservice.controller;

import org.example.userservice.model.UserServiceModel;
import org.example.userservice.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserServiceController {

    @Autowired
    private UserServices userServices;

    @PostMapping("/register")
    public ResponseEntity<String> userRegisteration(@RequestBody UserServiceModel user){
        userServices.storeUserInfo(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
    }

    @GetMapping("/profile")
    public List<UserServiceModel> getAllUser(){
        return userServices.getAllUserInfo();
    }
    @GetMapping("/profile/{userId}")
    public UserServiceModel getUser(@PathVariable String userId) {
        return userServices.getByUserId(userId);
    }
}
