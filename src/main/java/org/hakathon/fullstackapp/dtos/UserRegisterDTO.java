package org.hakathon.fullstackapp.dtos;

import org.hakathon.fullstackapp.models.User;

public class UserRegisterDTO {

    private String name;
    private String password;
    private String email;

    public UserRegisterDTO(String name, String password, String email){
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public User createUser(){
        return new User(this.name, this.email, this.password);
    }

}
