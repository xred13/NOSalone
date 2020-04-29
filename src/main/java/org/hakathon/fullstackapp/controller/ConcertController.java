package org.hakathon.fullstackapp.controller;

import org.hakathon.fullstackapp.dtos.ConcertDTO;
import org.hakathon.fullstackapp.model.Concert;
import org.hakathon.fullstackapp.repository.ConcertRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Array;
import java.net.URISyntaxException;
import java.util.*;
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

    @GetMapping("/buyconcert")
    public void buyConcert(@RequestParam(value = "artistName") String artistName, @RequestParam(value = "concertName") String concertName){

        Concert concertBought = ((Collection<Concert>) concertRepository.findAll()).stream().filter(concert -> concert.getConcertName().equals(concertName) && concert.getArtistName().equals(artistName)).collect(Collectors.toList()).get(0);

        concertRepository.delete(concertBought);

    }

    @GetMapping("/concerts")
    Collection<ConcertDTO> concerts(@RequestParam(value = "musicGenre") String musicGenre) {

        Collection<Concert> concertCollection = ((Collection<Concert>) concertRepository.findAll()).stream().filter(concert -> concert.getMusicGenre().equals(musicGenre)).collect(Collectors.toList());

        Concert[] concertArray = concertCollection.toArray(new Concert[concertCollection.size()]);

        // delete concerts that have expired from the repository and remove them from the current concertCollection
        for (int i = 0; i < concertArray.length; i++) {
            if(concertArray[i].getDate().compareTo(Calendar.getInstance()) <= 0){
                concertRepository.delete(concertArray[i]);
                concertArray[i] = null;
            }
        }

        Collection<ConcertDTO> concertDTOCollection = new ArrayList<>();

        for (Concert concert : concertArray) {
            if(concert == null){
                continue;
            }
            concertDTOCollection.add(new ConcertDTO(concert.getDate(), concert.getArtistName(), concert.getConcertName(), concert.getMusicGenre(), concert.getImgBase64()));
        }

        return concertDTOCollection;
    }

    @PostMapping("/create")
    ResponseEntity<Concert> createConcert(@Valid @RequestBody ConcertDTO concertDTO) throws URISyntaxException {

        Concert concert = new Concert(concertDTO.getDate(), concertDTO.getArtistName(), concertDTO.getConcertName(), concertDTO.getMusicGenre(), concertDTO.getImgBase64());

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
