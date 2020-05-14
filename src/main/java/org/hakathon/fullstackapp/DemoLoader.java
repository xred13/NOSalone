package org.hakathon.fullstackapp;

import org.hakathon.fullstackapp.daos.ConcertDAO;
import org.hakathon.fullstackapp.daos.UserDAO;
import org.hakathon.fullstackapp.models.Concert;
import org.hakathon.fullstackapp.models.User;
import org.hakathon.fullstackapp.repositories.ConcertRepository;
import org.hakathon.fullstackapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
public class DemoLoader implements CommandLineRunner {

    private ConcertDAO concertDao;

    private UserDAO userDao;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public DemoLoader(UserDAO userDao, ConcertDAO concertDao, PasswordEncoder passwordEncoder){
        this.userDao = userDao;
        this.concertDao = concertDao;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public void run(String... strings) throws Exception {

        Calendar tomorrow = Calendar.getInstance();
        tomorrow.add(Calendar.DAY_OF_MONTH, 1);

        User artist = new User("xred", "xred@mail.com", passwordEncoder.encode("password"));

        artist.addOwnConcert(new Concert("Best concert ever!", "description goes here", "rock", 1, 60, tomorrow, artist, "https://picsum.photos/200/300"));

        Calendar yesterday = Calendar.getInstance();
        yesterday.add(Calendar.DAY_OF_MONTH, -1);

        artist.addOwnConcert(new Concert("Best concert ever!2", "description goes here2", "rock", 62, 62, yesterday, artist, "https://picsum.photos/200/300"));

        Calendar todayIn2Hours = Calendar.getInstance();
        todayIn2Hours.add(Calendar.HOUR, 2);

        artist.addOwnConcert(new Concert("Best concert ever3", "description goes here2", "rock", 62, 62, todayIn2Hours, artist, "https://picsum.photos/200/300"));

        userDao.save(artist);

    }


}
