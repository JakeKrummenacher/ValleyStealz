package com.grouptwelve.valleystealz.controllers;

import com.grouptwelve.valleystealz.models.LoginUser;
import com.grouptwelve.valleystealz.models.User;
import com.grouptwelve.valleystealz.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/signin")
    public String signIn(Model model, HttpSession session) {
//		if the user still logged in then redirect to dashboard
        if(session.getAttribute("uuid")!= null) {
            return "redirect:/";
        }
//		passing in the Empty Objects
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());

        return "login.jsp";
    }

    //	POST Mapping for Register: same as Create
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result,Model model, HttpSession session) {
//		First we need to run our Register Function: passing in newUser and result
//		the error checking is done in our Service that's why we pass in result
        User user = userService.register(newUser, result);

//		Check to see if there are any errors once again
        if(result.hasErrors()) {
//			when we re-render the page we still need both the newUser Object and the newLogin User Object
            model.addAttribute("newLogin", new LoginUser());
            return "login.jsp";
        }

//		If there are no Errors we save the user to the database
//		Using Session so the user doesn't need to keep logging in when navigating through the website
//		Saving the user id to Session:
//		So I Can access the users info in any method and any controllers once logged in
        session.setAttribute("uuid", user.getId()); // uuid = unique user id

        return "redirect:/products";
    }


    //	Post Mapping for Login
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin,BindingResult result,Model model, HttpSession session) {
        User user = userService.login(newLogin, result);

        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "login.jsp";
        }

        session.setAttribute("uuid", user.getId()); // uuid = unique user id

        return "redirect:/products";
    }

    //	Logging Out
//	Need to remove the userId attribute from session
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("uuid");

        return "redirect:/";
    }

}
