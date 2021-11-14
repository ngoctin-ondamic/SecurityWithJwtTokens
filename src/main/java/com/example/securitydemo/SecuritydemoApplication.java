package com.example.securitydemo;

import com.example.securitydemo.domain.Role;
import com.example.securitydemo.domain.User;
import com.example.securitydemo.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SecuritydemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecuritydemoApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));
            userService.saveUser(new User(null, "Ngoc Tin", "ngoctin", "123456", new ArrayList<Role>()));
            userService.saveUser(new User(null, "Le Nguyen", "lenguyen", "123456", new ArrayList<Role>()));
            userService.saveUser(new User(null, "Uyen Nhi", "uyennhi", "123456", new ArrayList<Role>()));
            userService.saveUser(new User(null, "Hai Dang", "haidang", "123456", new ArrayList<Role>()));
            userService.addRoleToUser("ngoctin", "ROLE_MANAGER");
            userService.addRoleToUser("lenguyen", "ROLE_SUPER_ADMIN");
            userService.addRoleToUser("haidang", "ROLE_ADMIN");
            userService.addRoleToUser("uyennhi", "ROLE_USER");

        };
    }
}
