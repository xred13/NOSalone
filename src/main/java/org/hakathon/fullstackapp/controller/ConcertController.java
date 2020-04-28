package org.hakathon.fullstackapp.controller;


import org.hakathon.fullstackapp.model.Concert;
import org.hakathon.fullstackapp.repository.ConcertRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/NosAlone/concert")
@CrossOrigin(origins = "http://localhost:3000")
public class ConcertController {


    private ConcertRepository concertRepository;


    public ConcertController(ConcertRepository concertRepository) {
        this.concertRepository = concertRepository;
    }

    @GetMapping("/concerts")
    Collection<Concert> concerts() {
        return (Collection<Concert>) concertRepository.findAll();
    }

    @PostMapping("/concerts")
    ResponseEntity<Concert> createConcert(@Valid @RequestBody Concert concert) throws URISyntaxException {
        Concert result = concertRepository.save(concert);
        return ResponseEntity.ok().body(result);
    }


    @GetMapping("/musicGenre")
    Collection<String> musicGenre() {
        List<String> allMusicGenre = new LinkedList<>();
        allMusicGenre.add("rock");
        allMusicGenre.add("jazz");
        return allMusicGenre;
    }


}
