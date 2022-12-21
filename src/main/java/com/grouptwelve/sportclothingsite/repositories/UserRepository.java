package com.grouptwelve.sportclothingsite.repositories;

import java.util.List;

import com.grouptwelve.sportclothingsite.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    List<User> findAll();
    User findById(Integer id);
}
