package com.example.springshop.services;
import com.example.springshop.domain.WorkshopUser;
import java.util.List;
import java.util.Optional;

public interface WorkshopUserService {

    Optional<WorkshopUser> findById(long id);
    void create(WorkshopUser workshopUser);
    void delete(long id);
    void update(WorkshopUser workshopUser);
    List<WorkshopUser> findAll();
}