package org.hakathon.fullstackapp.controller;

import io.jsonwebtoken.Jwts;
import org.hakathon.fullstackapp.models.Concert;
import org.hakathon.fullstackapp.services.ConcertService;
import org.hakathon.fullstackapp.utils.JWTHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.URISyntaxException;
import java.util.*;

@RestController
@RequestMapping(ConcertController.PATH)
@CrossOrigin(origins = "http://localhost:3000")
public class ConcertController {

    public static final String PATH = "/concerts";

    public static final String BUY_CONCERT_PATH = "/buy";
    public static final String GET_CONCERTS_OF_GENRE_PATH = "/get-concerts-of-genre";
    public static final String CREATE_CONCERT_PATH = "/create";

    public static final Set<String> SECURED_PATHS = new HashSet<>(Arrays.asList(
            PATH + BUY_CONCERT_PATH,
            PATH + CREATE_CONCERT_PATH
    ));

    private ConcertService concertService;

    @Autowired
    public ConcertController(ConcertService concertService){
        this.concertService = concertService;
    }

    @GetMapping(BUY_CONCERT_PATH)
    public void buyConcert(@RequestBody long concertId, @CookieValue("JWT") String jwtToken){

        String buyerName = Jwts.parser().parseClaimsJws(jwtToken).getSignature();
        System.out.println(buyerName);

        concertService.buyConcert(concertId, buyerName);

    }

    @GetMapping(GET_CONCERTS_OF_GENRE_PATH)
    public Collection<Concert> getConcertsOfGenre(@RequestBody String musicGenre) {
        return concertService.getConcertsOfGenre(musicGenre);
    }

    @PostMapping(CREATE_CONCERT_PATH)
    public void createConcert(@RequestBody Concert concert) throws URISyntaxException {
        concertService.createConcert(concert);
    }

}
