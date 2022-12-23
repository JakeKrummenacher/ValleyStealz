package com.grouptwelve.valleystealz.controllers;

import com.grouptwelve.valleystealz.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CartController {

    @Autowired
    UserService userService;

    @GetMapping("/cart")
    public String checkLogin() {
        return "redirect:/cart/1";
    }

    @GetMapping("/cart/{userId}")
    public String showCart(@PathVariable("userId") Long userId, Model model) {
        model.addAttribute("user", userService.getOne(userId));
        return "showCart.jsp";
    }
}
