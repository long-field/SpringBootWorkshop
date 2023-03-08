package com.example.springshop.controllers;

import com.example.springshop.forms.NewWorkshopUserForm;
import com.example.springshop.services.WorkshopUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RestController
@RequestMapping("/")
public class IndexController {
    private final WorkshopUserService workshopUserService;


    public IndexController(WorkshopUserService workshopUserService) {
        this.workshopUserService = workshopUserService;
    }

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index").addObject(new NewWorkshopUserForm(null, null, null, 0));

        return modelAndView;
    }
}
