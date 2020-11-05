package org.hakathon.fullstackapp.controllers.concerts;

import org.hakathon.fullstackapp.dtos.sent.ConcertDto;
import org.hakathon.fullstackapp.dtos.received.GenericContainerDto;
import org.hakathon.fullstackapp.enums.MusicGenre;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;

import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

import static org.hakathon.fullstackapp.helper.Helper.asJsonString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

public class GetOfGenreTest extends AbstractConcertsControllerTestSetup {

    @Mock
    private GenericContainerDto<MusicGenre> musicGenreContainerDto;

    @BeforeEach
    @Override
    public void setup() {
        super.setup();
    }

    @Test
    public void testGetConcertsOfGenreSuccessful() throws Exception {

        MusicGenre musicGenre = MusicGenre.CLASSIC;



        when(musicGenreContainerDto.getData()).thenReturn(musicGenre);

        when(concertService.getConcertsOfGenre(musicGenre)).thenReturn(concertDtoTestCollection);

        assert concertDtoTestCollection.equals(concertController.getConcertsOfGenre(musicGenreContainerDto, null));

        GenericContainerDto<String> reqMusicGenreContainerDto = new GenericContainerDto<>(musicGenre.toString());

        System.out.println(asJsonString(reqMusicGenreContainerDto));

        mockMvc.perform(
                post("/concerts/get-concerts-of-genre")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(reqMusicGenreContainerDto))
        )
                .andExpect(status().isOk())
                .andExpect(content().json(asJsonString(concertDtoTestCollection)));
    }

    @Test
    public void testNullMusicGenre() throws Exception {

        MusicGenre invalidMusicGenre = null;
        Collection<ConcertDto> concertDtoCollection = null;

        when(musicGenreContainerDto.getData()).thenReturn(invalidMusicGenre);

        HttpServletResponse httpServletResponse = new MockHttpServletResponse();

        assert concertController.getConcertsOfGenre(musicGenreContainerDto, httpServletResponse) == concertDtoCollection;
        assert httpServletResponse.getStatus() == HttpStatus.BAD_REQUEST.value();

        GenericContainerDto<MusicGenre> reqMusicGenreContainerDto = new GenericContainerDto<>(invalidMusicGenre);

        mockMvc.perform(
                post("/concerts/get-concerts-of-genre")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(reqMusicGenreContainerDto))
        )
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testInvalidMusicGenre() throws Exception {

        GenericContainerDto<String> reqMusicGenreContainerDto = new GenericContainerDto<>("non-existent music genre");

        mockMvc.perform(
                post("/concerts/get-concerts-of-genre")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(reqMusicGenreContainerDto))
        )
                .andExpect(status().isBadRequest());
    }
}
