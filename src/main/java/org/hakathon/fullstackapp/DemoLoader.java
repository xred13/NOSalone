package org.hakathon.fullstackapp;

import org.hakathon.fullstackapp.model.Concert;
import org.hakathon.fullstackapp.repository.ConcertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
public class DemoLoader implements CommandLineRunner {

    private final ConcertRepository concertRepository;

    @Autowired
    public DemoLoader(ConcertRepository concertRepository) {
        this.concertRepository = concertRepository;
    }

    @Override
    public void run(String... strings) throws Exception {

        Calendar tomorrow = Calendar.getInstance();
        tomorrow.add(Calendar.DAY_OF_MONTH, 1);

        this.concertRepository.save(new Concert(tomorrow, "JAIMAO", "ShowDoJaime", "rock","https://picsum.photos/200/300"));
        this.concertRepository.save(new Concert(tomorrow, "BENNAZI", "Show2", "jazz","https://picsum.photos/200/300"));
    }


}
