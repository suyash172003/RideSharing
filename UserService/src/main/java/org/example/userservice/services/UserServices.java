package org.example.userservice.services;

import org.example.userservice.model.UserServiceModel;
import org.example.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServices {

    @Autowired
    UserRepository userRepository;

    public void storeUserInfo(UserServiceModel user) {
        user.setUserId(UUID.randomUUID().toString());
        userRepository.save(user);
    }

    public List<UserServiceModel> getAllUserInfo() {
        return userRepository.findAll();
    }

    public UserServiceModel getByUserId(String userId) {
        return userRepository.findById(userId).orElse(null);
    }
}
