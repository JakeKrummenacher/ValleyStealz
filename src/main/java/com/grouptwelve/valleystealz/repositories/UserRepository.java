package com.grouptwelve.valleystealz.repositories;

import com.grouptwelve.valleystealz.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    List<User> findAll();
    User findById(Integer id);
    Optional<User> findByEmail(String email);
}
