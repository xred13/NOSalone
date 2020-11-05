package org.hakathon.fullstackapp.controllers.concerts;

import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.servlet.http.Cookie;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.hakathon.fullstackapp.helper.Helper.asJsonString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class GetBoughtConcertsOfUserTest extends AbstractConcertsControllerTestSetup{

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
    public void testGetOwnedConcertsOfUser() throws Exception{

        when(concertService.getConcertsBoughtOfUser(userName)).thenReturn(concertDtoTestCollection);

        mockMvc.perform(
                get("/concerts/get-bought-concerts-of-user")
                        .cookie(new Cookie("JWT", jwtToken))
        )
                .andExpect(status().isOk())
                .andExpect(content().json(asJsonString(concertDtoTestCollection)));
    }



}