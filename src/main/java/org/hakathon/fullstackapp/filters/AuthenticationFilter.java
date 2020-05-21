package org.hakathon.fullstackapp.filters;

import io.jsonwebtoken.*;
import org.hakathon.fullstackapp.controller.ConcertController;
import org.hakathon.fullstackapp.controller.UserController;
import org.hakathon.fullstackapp.models.Concert;
import org.hakathon.fullstackapp.utils.JWTHelper;
import org.hakathon.fullstackapp.utils.ServletPathHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(2)
public class AuthenticationFilter implements Filter {

    private JWTHelper jwtHelper;

    @Autowired
    public AuthenticationFilter(JWTHelper jwtHelper){
        this.jwtHelper = jwtHelper;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        String servletPath = httpServletRequest.getServletPath();

        if (ServletPathHelper.isPathSecured(servletPath)) {

            Cookie[] cookies = httpServletRequest.getCookies();

            if(cookies == null){
                return;
            }

            for (int i = 0; i < cookies.length; i++) {

                Cookie cookie = cookies[i];

                if (cookie.getName().equals("JWT")) {

                    try {

                        Jws<Claims> jwsClaims = jwtHelper.checkTokenValidity(cookie.getValue());

                        //replace cookie with a new one with updated expiration date
                        httpServletResponse.addCookie(jwtHelper.createTokenCookie(jwsClaims.getBody().getSubject()));

                        filterChain.doFilter(servletRequest, servletResponse);

                    }
                    catch(SignatureException ignore){
                        //invalid jwt
                    }
                }
            }
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
