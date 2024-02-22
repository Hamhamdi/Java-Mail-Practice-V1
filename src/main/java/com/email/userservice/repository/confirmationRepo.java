package com.email.userservice.repository;

import com.email.userservice.models.Confirmation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface confirmationRepo extends JpaRepository<Confirmation, Long> {
    Confirmation findByToken(String token);
}
