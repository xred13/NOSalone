package org.hakathon.fullstackapp.controller;

import io.jsonwebtoken.*;
import org.hakathon.fullstackapp.dtos.sent.ConcertDto;
import org.hakathon.fullstackapp.dtos.received.GenericContainerDto;
import org.hakathon.fullstackapp.enums.MusicGenre;
import org.hakathon.fullstackapp.services.ConcertService;
import org.hakathon.fullstackapp.utils.JWTHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.servlet.http.HttpServletResponse;
import java.io.Console;
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

    private JWTHelper jwtHelper;

    @Autowired
    public ConcertController(ConcertService concertService, JWTHelper jwtHelper) {
        this.concertService = concertService;
        this.jwtHelper = jwtHelper;
    }

    @PostMapping(BUY_CONCERT_PATH)
    public ResponseEntity<?> buyConcert(@RequestBody GenericContainerDto<Long> idContainer, @CookieValue("JWT") String jwtToken) {

        Claims body = jwtHelper.getBodyOfTokenWithoutValidating(jwtToken);

        String buyerName = body.getSubject();

        try {
            concertService.buyConcert(idContainer.getData(), buyerName);
            return ResponseEntity.ok().build();

        } catch (HttpClientErrorException e) {
            return new ResponseEntity<>(e.getStatusText(), HttpStatus.BAD_REQUEST);
        }


    }

    @PostMapping(GET_CONCERTS_OF_GENRE_PATH)
    public Collection<ConcertDto> getConcertsOfGenre(@RequestBody GenericContainerDto<MusicGenre> genreContainer, HttpServletResponse response) {
        // if an invalid music genre is given
        if(genreContainer.getData() == null){
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            return null;
        }

        return concertService.getConcertsOfGenre(genreContainer.getData());
    }

    @GetMapping(GET_OWNED_CONCERTS_OF_USER_PATH)
    public Collection<ConcertDto> getOwnedConcertsOfUser(@CookieValue("JWT") String jwtToken) {

        Claims body = jwtHelper.getBodyOfTokenWithoutValidating(jwtToken);

        String userName = body.getSubject();

        return concertService.getConcertsOwnedOfUser(userName);

    }

    ;

    @GetMapping(GET_BOUGHT_CONCERTS_OF_USER_PATH)
    public Collection<ConcertDto> getBoughtConcertsOfUser(@CookieValue("JWT") String jwtToken) {

        Claims body = jwtHelper.getBodyOfTokenWithoutValidating(jwtToken);

        String userName = body.getSubject();

        return concertService.getConcertsBoughtOfUser(userName);

    }

    @PostMapping(CREATE_CONCERT_PATH)
    public ResponseEntity<?> createConcert(@RequestBody ConcertDto concertDto, @CookieValue("JWT") String jwtToken) {

        Claims body = jwtHelper.getBodyOfTokenWithoutValidating(jwtToken);

        String buyerName = body.getSubject();

        concertService.createConcert(concertDto, buyerName);
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

}
