package com.grouptwelve.valleystealz.controllers;

import com.grouptwelve.valleystealz.models.User;
import com.grouptwelve.valleystealz.services.ProductService;
import com.grouptwelve.valleystealz.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class MainController {

    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    @GetMapping("/")
    public String index(HttpSession session, Model model) {
        User user;
        if (session.getAttribute("uuid") != null) {
            user = userService.getOne((Long)session.getAttribute("uuid"));
        } else {
            user = null;
        }
        model.addAttribute("loggedInUser", user);
        return "index.jsp";
    }




}
