package org.hakathon.fullstackapp.utils;

import io.jsonwebtoken.*;

import javax.crypto.KeyGenerator;
import javax.crypto.KeyGeneratorSpi;
import javax.servlet.http.Cookie;
import java.security.Key;
import java.security.KeyStore;
import java.util.Calendar;
import java.util.Date;

public class JWTHelper {

    private static final int TOKEN_EXPIRATION_DAYS = 0;
    private static final int TOKEN_EXPIRATION_HOURS = 0;
    private static final int TOKEN_EXPIRATION_MINUTES = 0;
    private static final int TOKEN_EXPIRATION_SECONDS = 10;

    private static String key = "AsgEiugrKG12345678901234567890ab";

    public static String createToken(String username){

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, TOKEN_EXPIRATION_DAYS);
        calendar.add(Calendar.HOUR_OF_DAY, TOKEN_EXPIRATION_HOURS);
        calendar.add(Calendar.MINUTE, TOKEN_EXPIRATION_MINUTES);
        calendar.add(Calendar.SECOND, TOKEN_EXPIRATION_SECONDS);

        return Jwts.builder().setSubject(username).setExpiration(calendar.getTime()).
                signWith(SignatureAlgorithm.HS256, key).compact();
    }

    public static Cookie createTokenCookie(String username){

        String jwtToken = createToken(username);

        Cookie jwtCookie = new Cookie("JWT", jwtToken);

        jwtCookie.setHttpOnly(true);

        return jwtCookie;

    }

    public static Jws<Claims> checkTokenValidity(String compactToken) throws SignatureException{

        return Jwts.parser().setSigningKey(key).parseClaimsJws(compactToken);

    }

}
