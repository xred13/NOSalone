package org.hakathon.fullstackapp;

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

    private ConcertRepository concertRepository;

    private UserRepository userRepository;

    @Autowired
    public DemoLoader(UserRepository userRepository, ConcertRepository concertRepository){
        this.userRepository = userRepository;
        this.concertRepository = concertRepository;
    }
    @Override
    public void run(String... strings) throws Exception {

        Calendar tomorrow = Calendar.getInstance();
        tomorrow.add(Calendar.DAY_OF_MONTH, 1);

        User artist = new User("xred", "xred@mail.com", "password");

        userRepository.save(artist);

        concertRepository.save(new Concert("Best concert ever!", "description goes here", "rock", 6, 60, tomorrow, artist, "no image"));

        Calendar yesterday = Calendar.getInstance();
        yesterday.add(Calendar.DAY_OF_MONTH, -1);

        concertRepository.save(new Concert("Best concert ever!2", "description goes here2", "rock", 62, 62, yesterday, artist, "no image"));

        Calendar todayIn2Hours = Calendar.getInstance();
        todayIn2Hours.add(Calendar.HOUR, 2);

        concertRepository.save(new Concert("Best concert ever3", "description goes here2", "rock", 62, 62, todayIn2Hours, artist, "no image"));


    }


}
