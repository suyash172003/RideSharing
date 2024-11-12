package org.example.userservice.repository;

import org.example.userservice.model.UserServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserServiceModel, String> {
}
