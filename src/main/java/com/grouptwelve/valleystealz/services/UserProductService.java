package com.grouptwelve.valleystealz.services;


import com.grouptwelve.valleystealz.models.UserProduct;
import com.grouptwelve.valleystealz.repositories.UserProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProductService {

    @Autowired
    UserProductRepository userProductRepository;

    public UserProduct createUserProduct(UserProduct userProduct){
        return userProductRepository.save(userProduct);
    }

}
