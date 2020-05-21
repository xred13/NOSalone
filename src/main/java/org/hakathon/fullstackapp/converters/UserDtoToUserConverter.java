package org.hakathon.fullstackapp.converters;

import org.hakathon.fullstackapp.dtos.UserDto;
import org.hakathon.fullstackapp.models.User;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

public class UserDtoToUserConverter {

    public static User convert(UserDto userDto){
        return User.builder()
                .email(userDto.getEmail())
                .name(userDto.getName())
                .password(userDto.getPassword())
                .build();
    }

}
