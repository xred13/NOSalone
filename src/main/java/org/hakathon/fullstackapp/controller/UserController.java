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
import javax.servlet.http.HttpServletRequest;
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

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping(LOGIN_PATH)
    public boolean login(@RequestBody UserLoginDTO userLoginDTO, HttpServletResponse httpServletResponse){

        if(userService.logIn(userLoginDTO.getName(), userLoginDTO.getPassword())){

            httpServletResponse.addCookie(JWTHelper.createTokenCookie(userLoginDTO.getName()));

            return true;
        }

        return false;

    }

    @GetMapping(LOGOUT_PATH)
    public void logout(HttpServletResponse httpServletResponse){
        httpServletResponse.addCookie(JWTHelper.createNullTokenCookie());
    }

    @PostMapping(REGISTER_PATH)
    public boolean register(@RequestBody UserRegisterDTO userRegisterDTO){
        return userService.register(userRegisterDTO);
    }

}
