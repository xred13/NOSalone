package org.hakathon.fullstackapp.controller;

import org.hakathon.fullstackapp.model.Artist;
import org.hakathon.fullstackapp.repository.ArtistRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;
import java.util.Collection;

@RestController
@RequestMapping("/NosAlone/artist")
@CrossOrigin(origins = "http://localhost:3000")
public class ArtistController {

    private ArtistRepository artistRepository;

    public ArtistController(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @GetMapping("/artists")
    Collection<Artist> artists() {
        return (Collection<Artist>) artistRepository.findAll();
    }

    @PostMapping("/artists")
    ResponseEntity<Artist> createArtist(@Valid @RequestBody Artist artist) throws URISyntaxException {
        Artist result = artistRepository.save(artist);
        return ResponseEntity.ok().body(result);
    }
}
