package org.hakathon.fullstackapp.controllers.concerts;

import io.jsonwebtoken.Claims;
import org.hakathon.fullstackapp.dtos.sent.ConcertDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import javax.servlet.http.Cookie;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.hakathon.fullstackapp.helper.Helper.asJsonString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CreateConcertTest extends AbstractConcertsControllerTestSetup{

    private String userName = "Test User Name";
    private String jwtToken = "Test token";

    @BeforeEach
    @Override
    public void setup() {
        super.setup();

        Claims body = mock(Claims.class);

        when(body.getSubject()).thenReturn(userName);
        when(jwtHelper.getBodyOfTokenWithoutValidating(jwtToken)).thenReturn(body);

    }

    @Test
    public void testCreateConcertSuccessfully() throws Exception{

        ConcertDto concertToBeCreated = (ConcertDto) concertDtoTestCollection.toArray()[0];

        mockMvc.perform(
                get("/concerts/get-owned-concerts-of-user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(concertToBeCreated))
                        .cookie(new Cookie("JWT", jwtToken))
        )
                .andExpect(status().isOk());
    }



}