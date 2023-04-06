package com.example.springshop.restcontrollers;

import com.example.springshop.domain.WorkshopUser;
import com.example.springshop.services.WorkshopUserService;
import org.springframework.stereotype.Component;


@Component
public class WorkshopUserResolver  {

    private final WorkshopUserService workshopUserService;

    public WorkshopUserResolver(WorkshopUserService workshopUserService) {
        this.workshopUserService = workshopUserService;
    }

    public WorkshopUser getWorkshopUserById(Long id) {
        return workshopUserService.findById(id).orElse(null);
    }

    public Iterable<WorkshopUser> getAllWorkshopUsers() {
        return workshopUserService.findAll();
    }

    public WorkshopUser createWorkshopUser(String voornaam, String familienaam, String email, long leeftijd) {
        WorkshopUser workshopUser = new WorkshopUser(voornaam, familienaam, email, leeftijd);
        workshopUserService.create(workshopUser);
        return workshopUser;
    }

    public WorkshopUser updateWorkshopUser(Long id, String voornaam, String familienaam, String email, long leeftijd) {
        WorkshopUser workshopUser = workshopUserService.findById(id).orElse(null);
        if (workshopUser != null) {
            workshopUser.setVoornaam(voornaam);
            workshopUser.setFamilienaam(familienaam);
            workshopUser.setEmail(email);
            workshopUser.setLeeftijd(leeftijd);
            workshopUserService.update(workshopUser);
        }
        return workshopUser;
    }

    public boolean deleteWorkshopUser(Long id) {
        WorkshopUser workshopUser = workshopUserService.findById(id).orElse(null);
        if (workshopUser != null) {
            workshopUserService.delete(id);
            return true;
        }
        return false;
    }
}