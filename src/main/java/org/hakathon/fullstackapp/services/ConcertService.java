package org.hakathon.fullstackapp.services;

import org.hakathon.fullstackapp.converters.ConcertDtoToConcertConverter;
import org.hakathon.fullstackapp.converters.ConcertToConcertDtoConverter;
import org.hakathon.fullstackapp.daos.ConcertDAO;
import org.hakathon.fullstackapp.daos.UserDAO;
import org.hakathon.fullstackapp.dtos.sent.ConcertDto;
import org.hakathon.fullstackapp.enums.MusicGenre;
import org.hakathon.fullstackapp.models.Concert;
import org.hakathon.fullstackapp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
public class ConcertService {

    private ConcertDAO concertDAO;
    private UserDAO userDAO;

    @Autowired
    public ConcertService(ConcertDAO concertDAO, UserDAO userDAO) {
        this.concertDAO = concertDAO;
        this.userDAO = userDAO;
    }

    public void buyConcert(long id, String buyerName) throws HttpClientErrorException{

        Optional<Concert> optionalConcert = concertDAO.get(id);
        Optional<User> optionalUser = userDAO.get(buyerName);

        if (!optionalConcert.isPresent()) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Could not find the requested concert.");
        }

        if(!optionalUser.isPresent()){
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "No user with the provided name found.");
        }

        Concert concert = optionalConcert.get();
        User buyer = optionalUser.get();


        if (!concert.buy(buyer)) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Concert is no longer buyable.");
        }

        buyer.addBoughtConcert(concert);

        concertDAO.save(concert);
        userDAO.save(buyer);

    }

    public Collection<ConcertDto> getConcertsOfGenre(MusicGenre genre) {
        Collection<Concert> concerts = concertDAO.findByGenreWithUpcomingPerformanceDate(genre);

        Collection<ConcertDto> concertDtoCollection = new ArrayList<>();

        for (Concert concert : concerts) {
            concertDtoCollection.add(ConcertToConcertDtoConverter.convert(concert));
        }

        return concertDtoCollection;

    }

    public void createConcert(ConcertDto concertDto, String concertCreatorName) {

        Optional<User> optionalUser = userDAO.get(concertCreatorName);

        if(!optionalUser.isPresent()){
            return;
        }

        User creator = optionalUser.get();

        Concert concert = ConcertDtoToConcertConverter.convert(concertDto);

        concert.setSlotsRemaining(concert.getSlots());
        concert.setArtist(creator);

        creator.addOwnConcert(concert);

        userDAO.save(creator);
    }

    public Collection<ConcertDto> getConcertsOwnedOfUser(String username){

        Optional<User> optionalUser = userDAO.get(username);

        if(!optionalUser.isPresent()){
            return new ArrayList<>();
        }

        User user = optionalUser.get();

        Collection<ConcertDto> concerts = new ArrayList<>();

        for (Concert concert : user.getOwnedConcerts()) {
            concerts.add(ConcertToConcertDtoConverter.convert(concert));
        }

        return concerts;
    }

    public Collection<ConcertDto> getConcertsBoughtOfUser(String username){

        Optional<User> optionalUser = userDAO.get(username);

        if(!optionalUser.isPresent()){
            return new ArrayList<>();
        }

        User user = optionalUser.get();

        Collection<ConcertDto> concerts = new ArrayList<>();

        for (Concert concert : user.getBoughtConcerts()) {
            concerts.add(ConcertToConcertDtoConverter.convert(concert));
        }

        return concerts;

    }

}
