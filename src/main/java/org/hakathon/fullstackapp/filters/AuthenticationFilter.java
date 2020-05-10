package org.hakathon.fullstackapp.filters;

import io.jsonwebtoken.*;
import org.hakathon.fullstackapp.controller.ConcertController;
import org.hakathon.fullstackapp.controller.UserController;
import org.hakathon.fullstackapp.models.Concert;
import org.hakathon.fullstackapp.utils.JWTHelper;
import org.hakathon.fullstackapp.utils.ServletPathHelper;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
@Order(1)
public class AuthenticationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        filterChain.doFilter(servletRequest, servletResponse);

        String servletPath = httpServletRequest.getServletPath();

        if (ServletPathHelper.isPathSecured(servletPath)) {

            Cookie[] cookies = httpServletRequest.getCookies();

            for (int i = 0; i < cookies.length; i++) {

                Cookie cookie = cookies[i];

                if (cookie.getName().equals("JWT")) {

                    try {

                        Jws<Claims> jwsClaims = JWTHelper.checkTokenValidity(cookie.getValue());

                        //replace token with a new one to update date
                        JWTHelper.createToken(jwsClaims.getBody().getSubject());

                        filterChain.doFilter(servletRequest, servletResponse);

                    }
                    catch(SignatureException ignore){
                        //invalid jwt
                    }
                }
            }
        }
    }
}
