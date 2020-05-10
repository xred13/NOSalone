package org.hakathon.fullstackapp.services;

import org.hakathon.fullstackapp.daos.UserDAO;
import org.hakathon.fullstackapp.dtos.UserRegisterDTO;
import org.hakathon.fullstackapp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.persistence.RollbackException;
import java.sql.SQLException;
import java.util.Optional;

@Service
public class UserService {

    private UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public boolean logIn(String username, String password) {

        Optional<User> optionalUser = userDAO.get(username);

        if (optionalUser.isPresent()) {

            User user = optionalUser.get();

            return user.getPassword().equals(password);

        }

        return false;

    }

    public boolean register(UserRegisterDTO userRegisterDTO) {

        try {

            userDAO.save(userRegisterDTO.createUser());
            return true;

        } catch (DataIntegrityViolationException e){
            return false;
        }

    }

}
