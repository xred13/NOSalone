package org.hakathon.fullstackapp.daos;

import org.hakathon.fullstackapp.models.User;
import org.hakathon.fullstackapp.repositories.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserDAO {

    private UserRepository userRepository;

    public UserDAO(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public Optional<User> get(String username){
        return userRepository.findByName(username);
    }

    public void save(User user){
        userRepository.save(user);
    }

}
