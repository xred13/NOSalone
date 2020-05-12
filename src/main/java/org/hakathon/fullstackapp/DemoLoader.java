package org.hakathon.fullstackapp;

import org.hakathon.fullstackapp.daos.ConcertDAO;
import org.hakathon.fullstackapp.daos.UserDAO;
import org.hakathon.fullstackapp.models.Concert;
import org.hakathon.fullstackapp.models.User;
import org.hakathon.fullstackapp.repositories.ConcertRepository;
import org.hakathon.fullstackapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
public class DemoLoader implements CommandLineRunner {

    private ConcertDAO concertDao;

    private UserDAO userDao;

    @Autowired
    public DemoLoader(UserDAO userDao, ConcertDAO concertDao){
        this.userDao = userDao;
        this.concertDao = concertDao;
    }
    @Override
    public void run(String... strings) throws Exception {

        Calendar tomorrow = Calendar.getInstance();
        tomorrow.add(Calendar.DAY_OF_MONTH, 1);

        User artist = new User("xred", "xred@mail.com", "password");

        artist = userDao.save(artist);

        Concert concert1 = concertDao.save(new Concert("Best concert ever!", "description goes here", "rock", 6, 60, tomorrow, artist, "no image"));
        artist.addOwnConcert(concert1);

        Calendar yesterday = Calendar.getInstance();
        yesterday.add(Calendar.DAY_OF_MONTH, -1);

        Concert concert2 = concertDao.save(new Concert("Best concert ever!2", "description goes here2", "rock", 62, 62, yesterday, artist, "no image"));
        artist.addOwnConcert(concert2);

        Calendar todayIn2Hours = Calendar.getInstance();
        todayIn2Hours.add(Calendar.HOUR, 2);

        Concert concert3 = concertDao.save(new Concert("Best concert ever3", "description goes here2", "rock", 62, 62, todayIn2Hours, artist, "no image"));
        artist.addOwnConcert(concert3);

        userDao.save(artist);

    }


}
