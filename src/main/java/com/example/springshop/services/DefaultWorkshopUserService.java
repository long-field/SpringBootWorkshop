package com.example.springshop.services;

import com.example.springshop.domain.WorkshopUser;
import com.example.springshop.repositories.WorkshopUserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DefaultWorkshopUserService implements WorkshopUserService {

    private final WorkshopUserRepository workshopUserRepository;

    public DefaultWorkshopUserService(WorkshopUserRepository workshopUserRepository) {
        this.workshopUserRepository = workshopUserRepository;
    }

    @Override
    public void create(WorkshopUser workshopUser) {workshopUserRepository.save(workshopUser);}
    @Override
    public Optional<WorkshopUser> findById(long id) {
        return workshopUserRepository.findById(id);
    }
    @Override
    public void delete(long id) {
        workshopUserRepository.deleteById(id);
    }
    @Override
    public void update(WorkshopUser workshopUser) {
        workshopUserRepository.save(workshopUser);
    }
    @Override
    public List<WorkshopUser> findAll() {
        return workshopUserRepository.findAll();
    }
}
