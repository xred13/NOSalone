package org.hakathon.fullstackapp.utils;

import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.DefaultJwtParser;
import org.hakathon.fullstackapp.controller.UserController;

import javax.servlet.http.Cookie;
import java.util.Calendar;

public class JWTHelper {

    private static final int TOKEN_EXPIRATION_MONTHS = 3;
    private static final int TOKEN_EXPIRATION_DAYS = 0;
    private static final int TOKEN_EXPIRATION_HOURS = 0;
    private static final int TOKEN_EXPIRATION_MINUTES = 0;
    private static final int TOKEN_EXPIRATION_SECONDS = 0;

    private static String key = "AsgEiugrKG12345678901234567890ab";

    public static String createToken(String username){

        Calendar calendar = getNewExpirationCalendar();

        return Jwts.builder().setSubject(username).setExpiration(calendar.getTime()).
                signWith(SignatureAlgorithm.HS256, key).compact();
    }

    public static Cookie createTokenCookie(String username){

        String jwtToken = createToken(username);

        Cookie jwtCookie = new Cookie("JWT", jwtToken);

        Calendar calendar = getNewExpirationCalendar();

        jwtCookie.setHttpOnly(true);
        jwtCookie.setMaxAge(getRemainingSecondsToCalendar(calendar));
        jwtCookie.setPath("/");

        return jwtCookie;

    }

    public static Cookie createNullTokenCookie(){
        Cookie jwtCookie = new Cookie("JWT", null);
        jwtCookie.setHttpOnly(true);
        jwtCookie.setMaxAge(0);
        jwtCookie.setPath("/");
        return jwtCookie;
    }

    public static Jws<Claims> checkTokenValidity(String compactToken) throws SignatureException{

        return Jwts.parser().setSigningKey(key).parseClaimsJws(compactToken);

    }

    public static Claims getBodyOfTokenWithoutValidating(String jwtToken){
        String[] splitToken = jwtToken.split("\\.");
        String unsignedToken = splitToken[0] + "." + splitToken[1] + ".";

        return (Claims) (new DefaultJwtParser().parse(unsignedToken).getBody());
    }

    private static int getRemainingSecondsToCalendar(Calendar calendar){
        return (int) ((calendar.getTimeInMillis() - Calendar.getInstance().getTimeInMillis()) / 1000);
    }

    public static Calendar getNewExpirationCalendar(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, TOKEN_EXPIRATION_MONTHS);
        calendar.add(Calendar.DAY_OF_MONTH, TOKEN_EXPIRATION_DAYS);
        calendar.add(Calendar.HOUR_OF_DAY, TOKEN_EXPIRATION_HOURS);
        calendar.add(Calendar.MINUTE, TOKEN_EXPIRATION_MINUTES);
        calendar.add(Calendar.SECOND, TOKEN_EXPIRATION_SECONDS);
        return calendar;
    }

}
