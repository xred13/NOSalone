package org.hakathon.fullstackapp.services;

import org.hakathon.fullstackapp.daos.UserDAO;
import org.hakathon.fullstackapp.dtos.UserRegisterDTO;
import org.hakathon.fullstackapp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserDAO userDAO;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserDAO userDAO, PasswordEncoder passwordEncoder) {
        this.userDAO = userDAO;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean logIn(String username, String password) {

        Optional<User> optionalUser = userDAO.get(username);

        if (optionalUser.isPresent()) {

            User user = optionalUser.get();

            return passwordEncoder.matches(password, user.getPassword());

        }

        return false;

    }

    public boolean register(UserRegisterDTO userRegisterDTO) {

        User user = new User(userRegisterDTO.getName(), userRegisterDTO.getEmail(), passwordEncoder.encode(userRegisterDTO.getPassword()));

        try {

            userDAO.save(user);
            return true;

        } catch (DataIntegrityViolationException e){
            return false;
        }

    }

}
