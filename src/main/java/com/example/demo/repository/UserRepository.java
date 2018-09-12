package com.example.demo.repository;

import com.example.demo.domain.People;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<People,Long> {
    People findByUserName(String name);
}
