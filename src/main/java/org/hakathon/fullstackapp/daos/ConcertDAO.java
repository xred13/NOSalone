package org.hakathon.fullstackapp.daos;

import org.hakathon.fullstackapp.enums.MusicGenre;
import org.hakathon.fullstackapp.models.Concert;
import org.hakathon.fullstackapp.repositories.ConcertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

@Repository
public class ConcertDAO {

    private ConcertRepository concertRepository;

    @Autowired
    public ConcertDAO(ConcertRepository concertRepository){
        this.concertRepository = concertRepository;
    }

    public Optional<Concert> get(long id){
        return concertRepository.findById(id);
    }

    public Collection<Concert> findByGenreWithUpcomingPerformanceDate(MusicGenre genre){

        return concertRepository.findByMusicGenreWithUpcomingPerformanceDate(genre);

    }

    public void delete(long id){
        concertRepository.deleteById(id);
    }

    public Concert save(Concert concert){
        return concertRepository.save(concert);
    }




}
