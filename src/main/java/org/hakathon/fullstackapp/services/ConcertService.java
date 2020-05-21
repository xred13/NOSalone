package org.hakathon.fullstackapp.services;

import org.hakathon.fullstackapp.converters.ConcertConverter;
import org.hakathon.fullstackapp.daos.ConcertDAO;
import org.hakathon.fullstackapp.daos.UserDAO;
import org.hakathon.fullstackapp.dtos.ConcertDto;
import org.hakathon.fullstackapp.models.Concert;
import org.hakathon.fullstackapp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public boolean buyConcert(long id, String buyerName) {

        Optional<Concert> optionalConcert = concertDAO.get(id);
        Optional<User> optionalUser = userDAO.get(buyerName);

        if (!optionalConcert.isPresent() || !optionalUser.isPresent()) {
            return false;
        }

        Concert concert = optionalConcert.get();
        User buyer = optionalUser.get();


        if (concert.buy(buyer)) {

            buyer.addBoughtConcert(concert);

            concertDAO.save(concert);
            userDAO.save(buyer);

            return true;
        }

        return false;

    }

    public Collection<ConcertDto> getConcertsOfGenre(String genre) {
        Collection<Concert> concerts = concertDAO.get(genre);

        Collection<ConcertDto> concertDtos = new ArrayList<>();

        for (Concert concert : concerts) {
            concertDtos.add(ConcertConverter.convert(concert));
        }

        return concertDtos;

    }

    public void createConcert(ConcertDto concertDto, String concertCreatorName) {

        Optional<User> optionalUser = userDAO.get(concertCreatorName);

        if(!optionalUser.isPresent()){
            return;
        }

        User creator = optionalUser.get();

        Concert concert = ConcertConverter.convert(concertDto);

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

        for (Concert concert : user.getConcertsOwned()) {
            concerts.add(ConcertConverter.convert(concert));
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

        for (Concert concert : user.getConcertsBought()) {
            concerts.add(ConcertConverter.convert(concert));
        }

        return concerts;

    }

}
