package com.grouptwelve.sportclothingsite.repositories;

import com.grouptwelve.sportclothingsite.models.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long> {
    List<Cart> findAll();
    Cart findById();
}
