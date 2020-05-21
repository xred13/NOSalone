package org.hakathon.fullstackapp.builders;

import org.hakathon.fullstackapp.models.User;

import javax.persistence.Column;

public class UserBuilder {

    private String name;

    private String email;

    private String password;

    public UserBuilder setName(String name){
        this.name = name;
        return this;
    }

    public UserBuilder setEmail(String email){
        this.email = email;
        return this;
    }

    public UserBuilder setPassword(String password){
        this.password = password;
        return this;
    }

    public User build(){

        User user = new User();

        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);

        return user;
    }

}
