package com.grouptwelve.valleystealz.repositories;

import com.grouptwelve.valleystealz.models.UserProduct;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserProductRepository extends CrudRepository<UserProduct, Long> {
    List<UserProduct> findAll();
}
