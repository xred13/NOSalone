package org.hakathon.fullstackapp.controller;

import io.jsonwebtoken.*;
import org.hakathon.fullstackapp.dtos.ConcertDto;
import org.hakathon.fullstackapp.dtos.GenericContainerDto;
import org.hakathon.fullstackapp.enums.MusicGenre;
import org.hakathon.fullstackapp.services.ConcertService;
import org.hakathon.fullstackapp.utils.JWTHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

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
    public ConcertController(ConcertService concertService) {
        this.concertService = concertService;
    }

    @PostMapping(BUY_CONCERT_PATH)
    public ResponseEntity<Void> buyConcert(@RequestBody GenericContainerDto<Long> idContainer, @CookieValue("JWT") String jwtToken) throws HttpClientErrorException{

        Claims body = JWTHelper.getBodyOfTokenWithoutValidating(jwtToken);

        String buyerName = body.getSubject();

        concertService.buyConcert(idContainer.getData(), buyerName);
        return ResponseEntity.ok().build();


    }

    @PostMapping(GET_CONCERTS_OF_GENRE_PATH)
    public Collection<ConcertDto> getConcertsOfGenre(@RequestBody GenericContainerDto<MusicGenre> genreContainer) {
        return concertService.getConcertsOfGenre(genreContainer.getData());
    }

    @GetMapping(GET_OWNED_CONCERTS_OF_USER_PATH)
    public Collection<ConcertDto> getOwnedConcertsOfUser(@CookieValue("JWT") String jwtToken) {

        Claims body = JWTHelper.getBodyOfTokenWithoutValidating(jwtToken);

        String userName = body.getSubject();

        return concertService.getConcertsOwnedOfUser(userName);

    }

    ;

    @GetMapping(GET_BOUGHT_CONCERTS_OF_USER_PATH)
    public Collection<ConcertDto> getBoughtConcertsOfUser(@CookieValue("JWT") String jwtToken) {

        Claims body = JWTHelper.getBodyOfTokenWithoutValidating(jwtToken);

        String userName = body.getSubject();

        return concertService.getConcertsBoughtOfUser(userName);

    }

    @PostMapping(CREATE_CONCERT_PATH)
    public void createConcert(@RequestBody ConcertDto concertDto, @CookieValue("JWT") String jwtToken) {

        Claims body = JWTHelper.getBodyOfTokenWithoutValidating(jwtToken);

        String buyerName = body.getSubject();

        concertService.createConcert(concertDto, buyerName);
    }

}
