package org.hakathon.fullstackapp.controllers.concerts;

import io.jsonwebtoken.Claims;
import org.hakathon.fullstackapp.dtos.received.GenericContainerDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

import javax.servlet.http.Cookie;

import static org.hakathon.fullstackapp.helper.Helper.asJsonString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class BuyConcertTest extends AbstractConcertsControllerTestSetup {

    private long id = 0L;
    private String jwtToken = "Test Token";
    private String userName = "Test Name";

    @Mock
    private GenericContainerDto<Long> idContainerDto;

    private GenericContainerDto<Long> reqIdContainer;

    @BeforeEach
    @Override
    public void setup() {
        super.setup();

        Claims body = mock(Claims.class);
        when(jwtHelper.getBodyOfTokenWithoutValidating(jwtToken)).thenReturn(body);
        when(body.getSubject()).thenReturn(userName);

        when(idContainerDto.getData()).thenReturn(id);

        reqIdContainer = new GenericContainerDto<>(id);

    }

    @Test
    public void testBuyConcertSuccessful() throws Exception {

        doNothing().when(concertService).buyConcert(id, userName);

        ResponseEntity<?> response = concertController.buyConcert(idContainerDto, jwtToken);

        assert response.equals(ResponseEntity.ok().build());

        mockMvc.perform(
                post("/concerts/buy")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(reqIdContainer))
                        .cookie(new Cookie("JWT", jwtToken))
        )
                .andExpect(status().isOk());

    }

    @Test
    public void testBuyConcertUnsuccessful() throws Exception {

        String errorMessage = "Concert is no longer buyable.";

        doThrow(new HttpClientErrorException(HttpStatus.BAD_REQUEST, errorMessage)).when(concertService).buyConcert(id, userName);

        ResponseEntity<?> response = concertController.buyConcert(idContainerDto, jwtToken);

        assert response.equals(new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST));

        mockMvc.perform(
                post("/concerts/buy")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(reqIdContainer))
                        .cookie(new Cookie("JWT", jwtToken))
        )
                .andExpect(status().isBadRequest())
                .andExpect(content().string(errorMessage));

    }

    @Test
    public void testBuyConcertWrongConcertId() throws Exception {

        String errorMessage = "Could not find the requested concert.";

        doThrow(new HttpClientErrorException(HttpStatus.BAD_REQUEST, errorMessage)).when(concertService).buyConcert(id, userName);

        ResponseEntity<?> response = concertController.buyConcert(idContainerDto, jwtToken);

        assert response.equals(new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST));

        mockMvc.perform(
                post("/concerts/buy")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(reqIdContainer))
                        .cookie(new Cookie("JWT", jwtToken))
        )
                .andExpect(status().isBadRequest())
                .andExpect(content().string(errorMessage));

    }

    @Test
    public void testBuyConcertWrongUserName() throws Exception {

        String errorMessage = "No user with the provided name found.";

        doThrow(new HttpClientErrorException(HttpStatus.BAD_REQUEST, errorMessage)).when(concertService).buyConcert(id, userName);

        ResponseEntity<?> response = concertController.buyConcert(idContainerDto, jwtToken);

        assert response.equals(new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST));

        mockMvc.perform(
                post("/concerts/buy")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(reqIdContainer))
                        .cookie(new Cookie("JWT", jwtToken))
        )
                .andExpect(status().isBadRequest())
                .andExpect(content().string(errorMessage));

    }

}
