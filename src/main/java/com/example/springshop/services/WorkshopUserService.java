package com.example.springshop.services;

import com.example.springshop.domain.WorkshopUser;

import java.util.Optional;
import java.util.Set;

public interface WorkshopUserService {
    Optional<WorkshopUser> findById(long id);

    void create(WorkshopUser workshopUser);

    void delete(long id);

    void update(WorkshopUser workshopUser);

    Set<WorkshopUser> findAll();
}
