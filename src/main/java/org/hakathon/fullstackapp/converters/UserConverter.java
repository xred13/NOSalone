package org.hakathon.fullstackapp.converters;

import org.hakathon.fullstackapp.builders.UserBuilder;
import org.hakathon.fullstackapp.dtos.UserDto;
import org.hakathon.fullstackapp.models.User;

public class UserConverter {

    public static User convert(UserDto userDto){
        return new UserBuilder()
                .setEmail(userDto.getEmail())
                .setName(userDto.getName())
                .setPassword(userDto.getPassword())
                .build();
    }

}
