package com.example.securitydemo.repo;

import com.example.securitydemo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {

    User findByUsername(String username);
}
