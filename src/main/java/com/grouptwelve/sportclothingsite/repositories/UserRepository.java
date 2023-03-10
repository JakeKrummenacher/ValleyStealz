package com.grouptwelve.sportclothingsite.repositories;

import java.util.List;
import java.util.Optional;

import com.grouptwelve.sportclothingsite.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    List<User> findAll();
    User findById(Integer id);
    Optional<User> findByEmail(String email);
}
