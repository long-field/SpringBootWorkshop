package com.example.springshop.repositories;

import com.example.springshop.domain.WorkshopUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkshopUserRepository extends JpaRepository<WorkshopUser, Long> {
}
