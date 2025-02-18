package com.example.backangular.repository;


import com.example.backangular.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
   Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
}
