package org.hakathon.fullstackapp.converters;

import org.hakathon.fullstackapp.dtos.received.UserRegisterDto;
import org.hakathon.fullstackapp.models.User;

public class UserRegisterDtoToUserConverter {

    public static User convert(UserRegisterDto userRegisterDto){
        return User.builder()
                .email(userRegisterDto.getEmail())
                .name(userRegisterDto.getName())
                .password(userRegisterDto.getPassword())
                .build();
    }

}
