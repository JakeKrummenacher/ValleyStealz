package com.grouptwelve.sportclothingsite.controllers;

import com.grouptwelve.sportclothingsite.models.User;
import com.grouptwelve.sportclothingsite.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class MainController {

    @Autowired
    UserService userService;

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
