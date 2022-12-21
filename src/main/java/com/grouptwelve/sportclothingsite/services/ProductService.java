package com.grouptwelve.sportclothingsite.services;

import com.grouptwelve.sportclothingsite.models.Product;
import com.grouptwelve.sportclothingsite.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> allProducts() {return productRepository.findAll();}
    public Product createProduce(Product product){return productRepository.save(product);}

    public Product findProduct(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            return optionalProduct.get();
        } else {
            return null;
        }
    }

}
