package com.example.springshop.restcontrollers;

import com.example.springshop.domain.WorkshopUser;
import com.example.springshop.services.WorkshopUserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.hateoas.server.ExposesResourceFor;
import org.springframework.hateoas.server.TypedEntityLinks;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(value = "/WorkshopUser")

@ExposesResourceFor(WorkshopUser.class)
public class WorkShopUserController {

    private WorkshopUserService workshopUserService;
    private final TypedEntityLinks.ExtendedTypedEntityLinks<WorkshopUser> links;


    public WorkShopUserController(WorkshopUserService workshopUserService, EntityLinks links) {
        this.workshopUserService = workshopUserService;
        this.links = links.forType(WorkshopUser.class, WorkshopUser::getId);
    }


    @Operation(summary = "Find a user by Id")
    @GetMapping("/{id}")
    Optional<WorkshopUser> getWorkshopUserById(@PathVariable Long id) throws WorkshopUserNotFoundException {
        if (workshopUserService.findById(id).isEmpty()) {
            throw new WorkshopUserNotFoundException();
        }
        return workshopUserService.findById(id);
    }
    @Operation(summary = "Create a new User")
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    HttpHeaders create(@RequestBody @Valid WorkshopUser workshopUser) {
        workshopUserService.create(workshopUser);
        var headers = new HttpHeaders();
        headers.setLocation(links.linkToItemResource(workshopUser).toUri());
        return headers;
    }
    @Operation(summary = "Delete a user by Id")
    @DeleteMapping("/{id}")
    void delete(@PathVariable long id) {
        workshopUserService.delete(id);
    }

    @Operation(summary = "Update an existing user object")
    @PutMapping()
    HttpHeaders put(@RequestBody @Valid WorkshopUser workshopUser) throws WorkshopUserNotFoundException {
        var userFind = workshopUserService.findById(workshopUser.getId());
        if (userFind.isEmpty()) {
            throw new WorkshopUserNotFoundException();
        } else {
            workshopUserService.update(workshopUser);
            var headers = new HttpHeaders();
            headers.setLocation(links.linkToItemResource(workshopUser).toUri());
            return headers;
        }
    }

    @ExceptionHandler(WorkshopUserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    void WorkshopUserNotFound() {
    }


}
