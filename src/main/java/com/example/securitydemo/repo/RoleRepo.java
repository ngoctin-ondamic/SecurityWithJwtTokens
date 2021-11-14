package com.example.securitydemo.repo;

import com.example.securitydemo.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role,Long> {
    Role findByName(String name);
}
