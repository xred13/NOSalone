package org.hakathon.fullstackapp.controller;

import org.hakathon.fullstackapp.dtos.ConcertDTO;
import org.hakathon.fullstackapp.model.Concert;
import org.hakathon.fullstackapp.repository.ConcertRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/NosAlone/concert")
@CrossOrigin(origins = "http://localhost:3000")
public class ConcertController {


    private ConcertRepository concertRepository;


    public ConcertController(ConcertRepository concertRepository) {
        this.concertRepository = concertRepository;
    }

    @GetMapping("/concerts")
    Collection<ConcertDTO> concerts(@RequestParam(value = "musicGenre") String musicGenre) {

        Collection<Concert> concertCollection = ((Collection<Concert>) concertRepository.findAll()).stream().filter(concert -> concert.getMusicGenre().equals(musicGenre)).collect(Collectors.toList());

        Collection<ConcertDTO> concertDTOCollection = new ArrayList<>();

        for (Concert concert : concertCollection) {
            concertDTOCollection.add(new ConcertDTO(concert.getDate(), concert.getNumberMaxFans(), concert.getArtistName(), concert.getMusicGenre(), concert.getImgBase64()));
        }

        return concertDTOCollection;
    }

    @PostMapping("/concerts")
    ResponseEntity<Concert> createConcert(@Valid @RequestBody ConcertDTO concertDTO) throws URISyntaxException {

        Concert concert = new Concert(concertDTO.getDate(), concertDTO.getNumberMaxFans(), concertDTO.getArtistName(), concertDTO.getMusicGenre(), concertDTO.getImgBase64());

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
