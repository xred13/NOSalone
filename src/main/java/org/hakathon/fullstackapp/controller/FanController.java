package org.hakathon.fullstackapp.controller;

import org.hakathon.fullstackapp.model.Fan;
import org.hakathon.fullstackapp.repository.FanRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;
import java.util.Collection;

@RestController
@RequestMapping("/NosAlone/fan")
@CrossOrigin(origins = "http://localhost:3000")
public class FanController {

    private FanRepository fanRepository;

    public FanController(FanRepository fanRepository) {
        this.fanRepository = fanRepository;
    }

    @GetMapping("/fans")
    Collection<Fan> fans() {
        return (Collection<Fan>) fanRepository.findAll();
    }

    @PostMapping("/fans")
    ResponseEntity<Fan> createFan(@Valid @RequestBody Fan fan) throws URISyntaxException {
        Fan result = fanRepository.save(fan);
        return ResponseEntity.ok().body(result);
    }
}