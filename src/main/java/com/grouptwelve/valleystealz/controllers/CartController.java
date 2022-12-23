package com.grouptwelve.valleystealz.controllers;

import com.grouptwelve.valleystealz.models.User;
import com.grouptwelve.valleystealz.models.UserProduct;
import com.grouptwelve.valleystealz.services.ProductService;
import com.grouptwelve.valleystealz.services.UserProductService;
import com.grouptwelve.valleystealz.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@Controller
public class CartController {

    @Autowired
    UserService userService;

    @Autowired
    UserProductService userProductService;

    @Autowired
    ProductService productService;

    @GetMapping("/cart")
    public String checkLogin(HttpSession session, Model model) {
        User user;
        if (session.getAttribute("uuid") != null) {
            user = userService.getOne((Long)session.getAttribute("uuid"));
            return "redirect:/cart/" + user.getId();
        } else {
            return "redirect:/signin";
        }
    }

    @GetMapping("/cart/{userId}")
    public String showCart(@PathVariable("userId") Long userId, Model model, HttpSession session) {
        model.addAttribute("user", userService.getOne(userId));
        model.addAttribute("productService", productService);
        return "showCart.jsp";
    }

    @GetMapping("/cartadd/{id}")
    public String cartAdd(@PathVariable("id") int id, Model model, HttpSession session) {
        User user;
        if(session.getAttribute("uuid") != null) {
            user = userService.getOne((Long)session.getAttribute("uuid"));
            UserProduct userProduct = new UserProduct(id, 1, user);
            userProductService.createUserProduct(userProduct);
            return "redirect:/cart/" + user.getId();
        } else {
            return "redirect:/signin";
        }
    }


}
