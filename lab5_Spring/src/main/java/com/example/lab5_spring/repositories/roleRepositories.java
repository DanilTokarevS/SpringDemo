package com.example.lab5_spring.repositories;

import com.example.lab5_spring.Entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface roleRepositories extends JpaRepository<Roles, Long> {
}
