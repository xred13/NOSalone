package org.hakathon.fullstackapp.controllers.concerts;

import org.hakathon.fullstackapp.FullstackappApplication;
import org.hakathon.fullstackapp.controller.ConcertController;
import org.hakathon.fullstackapp.dtos.sent.ConcertDto;
import org.hakathon.fullstackapp.enums.MusicGenre;
import org.hakathon.fullstackapp.services.ConcertService;
import org.hakathon.fullstackapp.utils.JWTHelper;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;

import static org.mockito.Mockito.mock;

@SpringBootTest(classes = FullstackappApplication.class)
public abstract class AbstractConcertsControllerTestSetup {

    @Mock
    protected ConcertService concertService;

    @Mock
    protected JWTHelper jwtHelper;

    @InjectMocks
    protected ConcertController concertController;

    protected MockMvc mockMvc;

    protected Collection<ConcertDto> concertDtoTestCollection;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(concertController).build();

        Calendar tomorrow = Calendar.getInstance();
        tomorrow.add(Calendar.DAY_OF_MONTH, 1);

        concertDtoTestCollection = new ArrayList<>(
                Arrays.asList(
                        ConcertDto.builder()
                                .name("Concert name test")
                                .price(0)
                                .artistName("Great artist")
                                .musicGenre(MusicGenre.CLASSIC)
                                .performanceDate(tomorrow)
                                .imgBase64("https://picsum.photos/seed/picsum/200/300")
                                .description("Greatest concert ever")
                                .slots(4)
                                .slotsRemaining(3)
                                .build(),
                        ConcertDto.builder()
                                .name("Concert name test2")
                                .price(2)
                                .artistName("Great artist2")
                                .musicGenre(MusicGenre.CLASSIC)
                                .performanceDate(tomorrow)
                                .imgBase64("https://picsum.photos/seed/picsum/200/300")
                                .description("Greatest concert ever2")
                                .slots(2)
                                .slotsRemaining(2)
                                .build()
                )
        );
    }


}
