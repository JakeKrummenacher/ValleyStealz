package com.grouptwelve.sportclothingsite.services;

import com.grouptwelve.sportclothingsite.models.User;
import com.grouptwelve.sportclothingsite.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> allUsers() { return userRepository.findAll(); }

    public User createUser(User user) { return userRepository.save(user); }

    public User findUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            return null;
        }
    }
}
