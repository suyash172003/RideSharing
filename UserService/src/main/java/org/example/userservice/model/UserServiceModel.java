package org.example.userservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class UserServiceModel {
    @Id
    private String userId;
    private String name;
    private String password;
    private String email;
    private String phone;
}
