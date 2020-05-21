package org.hakathon.fullstackapp.controllers;

import io.jsonwebtoken.Claims;
import org.hakathon.fullstackapp.FullstackappApplication;
import org.hakathon.fullstackapp.controller.ConcertController;
import org.hakathon.fullstackapp.dtos.ConcertDto;
import org.hakathon.fullstackapp.dtos.GenericContainerDto;
import org.hakathon.fullstackapp.enums.MusicGenre;
import org.hakathon.fullstackapp.services.ConcertService;
import org.hakathon.fullstackapp.utils.JWTHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@SpringBootTest(classes = FullstackappApplication.class)
public class ConcertsControllerTest {

    @Mock
    private ConcertService concertService;

    @Mock
    private JWTHelper jwtHelper;

    @InjectMocks
    private ConcertController concertController;

    @SuppressWarnings("unchecked")
    @Test
    public void testBuyConcertSuccessful(){

         long id = 0L;
         String jwtToken = "Test Token";
         String userName = "test name";

        Claims body = mock(Claims.class);
        when(jwtHelper.getBodyOfTokenWithoutValidating(jwtToken)).thenReturn(body);
        when(body.getSubject()).thenReturn(userName);

        doNothing().when(concertService).buyConcert(id, userName);

         GenericContainerDto<Long> genericContainerDto = mock(GenericContainerDto.class);

         when(genericContainerDto.getData()).thenReturn(id);

         ResponseEntity<Void> response = concertController.buyConcert(genericContainerDto, jwtToken);

         assert response.equals(ResponseEntity.ok().<Void>build());

     }

     @SuppressWarnings("unchecked")
     @Test
     public void testBuyConcertUnsuccessful(){

         long id = 0L;
         String jwtToken = "Test Token";
         String userName = "test name";

         Claims body = mock(Claims.class);
         when(jwtHelper.getBodyOfTokenWithoutValidating(jwtToken)).thenReturn(body);
         when(body.getSubject()).thenReturn(userName);

         doThrow(new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Concert is no longer buyable.")).when(concertService).buyConcert(id, userName);

         GenericContainerDto<Long> genericContainerDto = mock(GenericContainerDto.class);

         when(genericContainerDto.getData()).thenReturn(id);

         HttpClientErrorException e = assertThrows(HttpClientErrorException.class, () -> concertController.buyConcert(genericContainerDto, jwtToken));

         assert e.getStatusText().equals("Concert is no longer buyable.");

     }

     @SuppressWarnings("unchecked")
     @Test
    public void testBuyConcertWrongConcertId(){

        long id = 0L;
        String jwtToken = "Test Token";
         String userName = "test name";

         Claims body = mock(Claims.class);
         when(jwtHelper.getBodyOfTokenWithoutValidating(jwtToken)).thenReturn(body);
         when(body.getSubject()).thenReturn(userName);

        doThrow(new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Could not find the requested concert.")).when(concertService).buyConcert(id, userName);

        GenericContainerDto<Long> genericContainerDto = mock(GenericContainerDto.class);

         when(genericContainerDto.getData()).thenReturn(id);

        HttpClientErrorException e = assertThrows(HttpClientErrorException.class, () -> concertController.buyConcert(genericContainerDto, jwtToken));

        assert e.getStatusText().equals("Could not find the requested concert.");

     }

    @SuppressWarnings("unchecked")
    @Test
    public void testBuyConcertWrongUserName(){

        long id = 0L;
        String jwtToken = "Test Token";
        String userName = "test name";

        Claims body = mock(Claims.class);
        when(jwtHelper.getBodyOfTokenWithoutValidating(jwtToken)).thenReturn(body);
        when(body.getSubject()).thenReturn(userName);

        doThrow(new HttpClientErrorException(HttpStatus.BAD_REQUEST, "No user with the provided name found.")).when(concertService).buyConcert(id, userName);

        GenericContainerDto<Long> genericContainerDto = mock(GenericContainerDto.class);

        when(genericContainerDto.getData()).thenReturn(id);

        HttpClientErrorException e = assertThrows(HttpClientErrorException.class, () -> concertController.buyConcert(genericContainerDto, jwtToken));

        assert e.getStatusText().equals("No user with the provided name found.");

    }

    @SuppressWarnings("unchecked")
    @Test
    public void testGetConcertsOfGenreSuccessful(){

        MusicGenre musicGenre = mock(MusicGenre.class);

        GenericContainerDto<MusicGenre> genericContainerDto = mock(GenericContainerDto.class);

        when(genericContainerDto.getData()).thenReturn(musicGenre);

        Collection<ConcertDto> concertDtos = mock(Collection.class);

        when(concertService.getConcertsOfGenre(musicGenre)).thenReturn(concertDtos);

        assert concertController.getConcertsOfGenre(genericContainerDto).equals(concertDtos);

    }

}
