package com.luv2code.jobportal.controller;


import com.luv2code.jobportal.services.UsersService;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import com.luv2code.jobportal.entity.Users;
import com.luv2code.jobportal.entity.UsersType;
import com.luv2code.jobportal.services.UsersTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class UsersController {

    private final UsersTypeService usersTypeService;
    private final UsersService usersService;


    @Autowired
    public UsersController(UsersTypeService usersTypeService, UsersService usersService) {
        this.usersTypeService = usersTypeService;
        this.usersService = usersService;
    }

    @GetMapping("/register")
    public String register(Model model) {
    List<UsersType> usersTypes = usersTypeService.getAll();
    model.addAttribute("getAllTypes",usersTypes);
    model.addAttribute("user", new Users());
    return "register";
    }
    @PostMapping("/register/new")
    public String userRegistration(@Valid Users users,Model model) {
       // System.out.println("User:: " +users);

        Optional<Users> optionalUsers = usersService.getUserByEmail((users.getEmail()));
        if (optionalUsers.isPresent())
        {

            model.addAttribute("error","This email already exists, try again or register with other email.");
            List<UsersType> usersTypes = usersTypeService.getAll();
            model.addAttribute("getAllTypes",usersTypes);
            model.addAttribute("user", new Users());
            return "register";
        }
        usersService.addNew(users);
        return  "dashboard";

    }


}
