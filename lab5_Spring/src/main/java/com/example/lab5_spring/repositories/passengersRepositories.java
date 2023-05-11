package com.example.lab5_spring.repositories;

import com.example.lab5_spring.Entity.passengers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface passengersRepositories extends JpaRepository<passengers, Long> {
}
