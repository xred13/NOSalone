package org.hakathon.fullstackapp.services;

import org.hakathon.fullstackapp.daos.ConcertDAO;
import org.hakathon.fullstackapp.daos.UserDAO;
import org.hakathon.fullstackapp.models.Concert;
import org.hakathon.fullstackapp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.RollbackException;
import java.util.Calendar;
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

            buyer.buyConcert(concert);

            concertDAO.save(concert);
            userDAO.save(buyer);

            return true;
        }

        return false;

    }

    public Collection<Concert> getConcertsOfGenre(String genre) {
        return concertDAO.get(genre);
    }

    public void createConcert(Concert concert, String concertCreatorName) {

        concertDAO.save(concert);

        Optional<User> optionalUser = userDAO.get(concertCreatorName);

        if(!optionalUser.isPresent()){
            return;
        }

        User creator = optionalUser.get();

        creator.addOwnConcert(concert);

        userDAO.save(creator);
    }

}
