package com.grouptwelve.valleystealz.services;

import com.grouptwelve.valleystealz.models.Cart;
import com.grouptwelve.valleystealz.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;

    public List<Cart> allCarts() {return cartRepository.findAll();}
    public Cart createCart(Cart cart){return cartRepository.save(cart);}

    public Cart findCart(Long id) {
        Optional<Cart> optionalCart = cartRepository.findById(id);
        if (optionalCart.isPresent()) {
            return optionalCart.get();
        } else {
            return null;
        }
    }

}
