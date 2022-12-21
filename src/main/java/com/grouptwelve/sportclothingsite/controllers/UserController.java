package com.grouptwelve.sportclothingsite.controllers;

import com.grouptwelve.sportclothingsite.models.User;
import com.grouptwelve.sportclothingsite.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping("/users/new")
    public String userForm(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("users", userService.allUsers());
        return "newUser.jsp";
    }
    @PostMapping("/users/create")
    public String addNinja(@Valid @ModelAttribute("user") User user, BindingResult result) {
        if(result.hasErrors()) {
            return "newUser.jsp";
        } else {
            userService.createUser(user);
            return "redirect:/";
        }
    }

}
