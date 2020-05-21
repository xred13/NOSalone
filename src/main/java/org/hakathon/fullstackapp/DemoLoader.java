package org.hakathon.fullstackapp;

import org.hakathon.fullstackapp.builders.ConcertBuilder;
import org.hakathon.fullstackapp.builders.UserBuilder;
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
import java.util.Collection;

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

        User user = new UserBuilder()
                .setEmail("user@mail.com")
                .setName("xred")
                .setPassword(passwordEncoder.encode("password"))
                .build();

        user = userDao.save(user);

        Concert concert = new ConcertBuilder()
                .setDescription("lololo")
                .setImgBase64("https://picsum.photos/seed/picsum/200/300")
                .setMusicGenre("classic")
                .setName("Summerland")
                .setPerformanceDate(tomorrow)
                .setPrice(0)
                .setSlots(20)
                .setSlotsRemaining(20)
                .setArtist(user)
                .build();

        user.addOwnConcert(concert);

        userDao.save(user);


    }


}
