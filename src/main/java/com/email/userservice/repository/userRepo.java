package com.email.userservice.repository;

import com.email.userservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepo extends JpaRepository<User,Long> {
    User findByEmailIgnoreCase(String email);
    Boolean existsByEmail(String email);
}
