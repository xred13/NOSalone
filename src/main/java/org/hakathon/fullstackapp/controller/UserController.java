package org.hakathon.fullstackapp.controller;

import org.hakathon.fullstackapp.dtos.UserDto;
import org.hakathon.fullstackapp.services.UserService;
import org.hakathon.fullstackapp.utils.JWTHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping(UserController.PATH)
public class UserController {

    public static final String PATH = "/users";

    public static final String LOGIN_PATH = "/login";
    public static final String LOGOUT_PATH = "/logout";
    public static final String REGISTER_PATH = "/register";

    public static final Set<String> SECURED_PATHS = new HashSet<>(Arrays.asList(
            PATH + LOGOUT_PATH
    ));

    private UserService userService;

    private JWTHelper jwtHelper;

    @Autowired
    public UserController(UserService userService, JWTHelper jwtHelper){
        this.userService = userService;
        this.jwtHelper = jwtHelper;
    }

    @PostMapping(LOGIN_PATH)
    public boolean login(@RequestBody UserDto userDto, HttpServletResponse httpServletResponse){

        if(userService.logIn(userDto.getName(), userDto.getPassword())){

            httpServletResponse.addCookie(jwtHelper.createTokenCookie(userDto.getName()));

            return true;
        }

        return false;

    }

    @GetMapping(LOGOUT_PATH)
    public void logout(HttpServletResponse httpServletResponse){
        httpServletResponse.addCookie(jwtHelper.createNullTokenCookie());
    }

    @PostMapping(REGISTER_PATH)
    public boolean register(@RequestBody UserDto userDto){
        return userService.register(userDto);
    }

}
