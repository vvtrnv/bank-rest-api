package com.example.bankrestapi.repository;

import com.example.bankrestapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    public User findByUsername(String username);
}
