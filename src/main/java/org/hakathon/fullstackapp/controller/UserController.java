package org.hakathon.fullstackapp.controller;

import com.sun.net.httpserver.Headers;
import org.hakathon.fullstackapp.dtos.UserLoginDTO;
import org.hakathon.fullstackapp.dtos.UserRegisterDTO;
import org.hakathon.fullstackapp.services.UserService;
import org.hakathon.fullstackapp.utils.JWTHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(UserController.PATH)
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    public static final String PATH = "/users";

    public static final String LOGIN_PATH = "/login";
    public static final String CREATE_PATH = "/register";

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @CrossOrigin(allowCredentials = "true")
    @PostMapping(LOGIN_PATH)
    public boolean login(@RequestBody UserLoginDTO userLoginDTO, HttpServletResponse httpServletResponse){

        if(userService.logIn(userLoginDTO.getName(), userLoginDTO.getPassword())){

            httpServletResponse.addCookie(JWTHelper.createTokenCookie(userLoginDTO.getName()));

            return true;
        }

        return false;

    }

    @PostMapping(CREATE_PATH)
    public boolean register(@RequestBody UserRegisterDTO userRegisterDTO){
        return userService.register(userRegisterDTO);
    }

}
