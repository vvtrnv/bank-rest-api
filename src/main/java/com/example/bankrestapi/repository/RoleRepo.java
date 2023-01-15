package com.example.bankrestapi.repository;

import com.example.bankrestapi.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
}
