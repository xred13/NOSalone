package org.hakathon.fullstackapp.controller;

import io.jsonwebtoken.*;
import org.hakathon.fullstackapp.dtos.ConcertBuyDTO;
import org.hakathon.fullstackapp.dtos.ConcertCreateDTO;
import org.hakathon.fullstackapp.dtos.ConcertGetOfGenreDTO;
import org.hakathon.fullstackapp.models.Concert;
import org.hakathon.fullstackapp.services.ConcertService;
import org.hakathon.fullstackapp.utils.JWTHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

@RestController
@RequestMapping(ConcertController.PATH)
public class ConcertController {

    public static final String PATH = "/concerts";

    public static final String BUY_CONCERT_PATH = "/buy";
    public static final String GET_CONCERTS_OF_GENRE_PATH = "/get-concerts-of-genre";
    public static final String CREATE_CONCERT_PATH = "/create";
    public static final String GET_OWNED_CONCERTS_OF_USER_PATH = "/get-owned-concerts-of-user";
    public static final String GET_BOUGHT_CONCERTS_OF_USER_PATH = "/get-bought-concerts-of-user";

    public static final Set<String> SECURED_PATHS = new HashSet<>(Arrays.asList(
            PATH + BUY_CONCERT_PATH,
            PATH + CREATE_CONCERT_PATH,
            PATH + GET_OWNED_CONCERTS_OF_USER_PATH,
            PATH + GET_BOUGHT_CONCERTS_OF_USER_PATH
    ));

    private ConcertService concertService;

    @Autowired
    public ConcertController(ConcertService concertService){
        this.concertService = concertService;
    }

    @PostMapping(BUY_CONCERT_PATH)
    public void buyConcert(@RequestBody ConcertBuyDTO concertBuyDTO, @CookieValue("JWT") String jwtToken){

        Claims body = JWTHelper.getBodyOfTokenWithoutValidating(jwtToken);
        
        String buyerName = body.getSubject();

        concertService.buyConcert(concertBuyDTO.getId(), buyerName);

    }

    @PostMapping(GET_CONCERTS_OF_GENRE_PATH)
    public Collection<Concert> getConcertsOfGenre(@RequestBody ConcertGetOfGenreDTO concertGetOfGenreDTO) {
        return concertService.getConcertsOfGenre(concertGetOfGenreDTO.getGenre());
    }

    @GetMapping(GET_OWNED_CONCERTS_OF_USER_PATH)
    public Collection<Concert> getOwnedConcertsOfUser(@CookieValue("JWT") String jwtToken){

        Claims body = JWTHelper.getBodyOfTokenWithoutValidating(jwtToken);

        String userName = body.getSubject();

        return concertService.getConcertsOwnedOfUser(userName);

    };

    @GetMapping(GET_BOUGHT_CONCERTS_OF_USER_PATH)
    public Collection<Concert> getBoughtConcertsOfUser(@CookieValue("JWT") String jwtToken){

        Claims body = JWTHelper.getBodyOfTokenWithoutValidating(jwtToken);

        String userName = body.getSubject();

        return concertService.getConcertsBoughtOfUser(userName);

    }

    @PostMapping(CREATE_CONCERT_PATH)
    public void createConcert(@RequestBody ConcertCreateDTO concertCreateDTO, @CookieValue("JWT") String jwtToken) {
        
        Claims body = JWTHelper.getBodyOfTokenWithoutValidating(jwtToken);

        String buyerName = body.getSubject();

        concertService.createConcert(concertCreateDTO, buyerName);
    }

}
