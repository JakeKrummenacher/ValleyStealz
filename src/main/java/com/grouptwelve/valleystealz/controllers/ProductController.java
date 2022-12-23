package com.grouptwelve.valleystealz.controllers;

import com.grouptwelve.valleystealz.models.Product;
import com.grouptwelve.valleystealz.models.User;
import com.grouptwelve.valleystealz.services.ProductService;
import com.grouptwelve.valleystealz.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public String Products(Model model, HttpSession session) {
        User user;
        if (session.getAttribute("uuid") != null) {
            user = userService.getOne((Long)session.getAttribute("uuid"));
        } else {
            user = null;
        }
        model.addAttribute("loggedInUser", user);

        List<Product> products = productService.allProducts();

        model.addAttribute("products", products);
        return "products.jsp";
    }

    @GetMapping("/products/{product_id}")
    public String oneProduct(@PathVariable("product_id") Long product_id, Model model, HttpSession session){
        User user;
        if (session.getAttribute("uuid") != null) {
            user = userService.getOne((Long)session.getAttribute("uuid"));
        } else {
            user = null;
        }
        model.addAttribute("loggedInUser", user);

        List<Product> products = productService.allProducts();

        model.addAttribute("products", products);
        Product product = productService.findProduct(product_id);
        model.addAttribute("product", product);
        return "oneProduct.jsp";
    }
}
