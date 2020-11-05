package org.hakathon.fullstackapp;

import org.hakathon.fullstackapp.converters.ConcertToConcertDtoConverter;
import org.hakathon.fullstackapp.daos.ConcertDAO;
import org.hakathon.fullstackapp.daos.UserDAO;
import org.hakathon.fullstackapp.dtos.received.ConcertCreateDto;
import org.hakathon.fullstackapp.dtos.sent.ConcertDto;
import org.hakathon.fullstackapp.enums.MusicGenre;
import org.hakathon.fullstackapp.models.Concert;
import org.hakathon.fullstackapp.models.User;
import org.hakathon.fullstackapp.repositories.ConcertRepository;
import org.hakathon.fullstackapp.repositories.UserRepository;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;

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

        User user = User.builder()
                .email("user@mail.com")
                .name("Artist404")
                .password(passwordEncoder.encode("password"))
                .build();

        user = userDao.save(user);

        Concert concert = Concert.builder()
                .description("A pretty good concert")
                .imgBase64("https://picsum.photos/seed/picsum/200/300")
                .musicGenre(MusicGenre.CLASSIC)
                .name("Summerland")
                .performanceDate(tomorrow)
                .price(5)
                .slots(2)
                .slotsRemaining(2)
                .artist(user)
                .build();

        user.addOwnConcert(concert);

        userDao.save(user);

        ConcertCreateDto concertDto = ConcertCreateDto.builder()
                .description("Another great concert")
                .imgBase64("https://picsum.photos/seed/picsum/200/300")
                .musicGenre(MusicGenre.CLASSIC)
                .name("Summerland")
                .performanceDate(tomorrow)
                .price(10)
                .slots(2)
                .slotsRemaining(2)
                .artistName("some")
                .build();

    }
}
