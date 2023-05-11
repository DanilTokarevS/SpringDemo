package com.example.lab5_spring.repositories;

import com.example.lab5_spring.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface userRepositories extends JpaRepository<Users, String> {

    Optional<Users> findByUsername(String username);
}
