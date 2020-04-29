package org.hakathon.fullstackapp;

import org.hakathon.fullstackapp.model.Artist;
import org.hakathon.fullstackapp.model.Concert;
import org.hakathon.fullstackapp.model.Fan;
import org.hakathon.fullstackapp.repository.ArtistRepository;
import org.hakathon.fullstackapp.repository.ConcertRepository;
import org.hakathon.fullstackapp.repository.FanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.SimpleTimeZone;

@Component
public class DemoLoader implements CommandLineRunner {

    private final ArtistRepository artistRepository;
    private final FanRepository fanRepository;
    private final ConcertRepository concertRepository;

    @Autowired
    public DemoLoader(ArtistRepository artistRepository, FanRepository fanRepository, ConcertRepository concertRepository) {
        this.artistRepository = artistRepository;
        this.fanRepository = fanRepository;
        this.concertRepository = concertRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        this.artistRepository.save(new Artist("Jaime","Verde", "jaime@verde.pt"));
        this.fanRepository.save(new Fan("Mariana", "Marçal", "maria@gmail.com"));
        this.concertRepository.save(new Concert(Calendar.getInstance(), 2, "JAIMAO", "ShowDoJaime", "rock","https://picsum.photos/200/300"));
        this.concertRepository.save(new Concert(Calendar.getInstance(), 1, "BENNAZI", "Show2", "jazz","https://picsum.photos/200/300"));
    }


}
