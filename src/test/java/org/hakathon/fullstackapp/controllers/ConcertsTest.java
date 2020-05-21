package org.hakathon.fullstackapp.controllers;

import org.hakathon.fullstackapp.controller.ConcertController;
import org.hakathon.fullstackapp.dtos.ConcertDto;
import org.hakathon.fullstackapp.dtos.GenericContainerDto;
import org.hakathon.fullstackapp.enums.MusicGenre;
import org.hakathon.fullstackapp.services.ConcertService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class ConcertsTest {

    @Mock
    private ConcertService concertService;

    @InjectMocks
    private ConcertController concertController;

    @SuppressWarnings("unchecked")
    @Test
    public void testBuyConcertSuccessful(){

         long id = 0L;
         String buyersName = "Test Name";

         doNothing().when(concertService).buyConcert(id, buyersName);

         GenericContainerDto<Long> genericContainerDto = mock(GenericContainerDto.class);

         ResponseEntity<Void> response = concertController.buyConcert(genericContainerDto, buyersName);

         assert response == ResponseEntity.ok().<Void>build();

     }

     @SuppressWarnings("unchecked")
     @Test
     public void testBuyConcertUnsuccessful(){

         long id = 0L;
         String buyersName = "Test Name";

         doThrow(new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Concert is no longer buyable.")).when(concertService).buyConcert(id, buyersName);

         GenericContainerDto<Long> genericContainerDto = mock(GenericContainerDto.class);

         concertController.buyConcert(genericContainerDto, buyersName);

         HttpClientErrorException e = assertThrows(HttpClientErrorException.class, () -> concertController.buyConcert(genericContainerDto, buyersName));

         assert e.getMessage() != null;
         assert e.getMessage().equals("Concert is no longer buyable.");

     }

     @SuppressWarnings("unchecked")
     @Test
    public void testBuyConcertWrongConcertId(){

        long id = 0L;
        String buyersName = "Test Name";

        doThrow(new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Could not find the requested concert.")).when(concertService).buyConcert(id, buyersName);

        GenericContainerDto<Long> genericContainerDto = mock(GenericContainerDto.class);

        concertController.buyConcert(genericContainerDto, buyersName);

        HttpClientErrorException e = assertThrows(HttpClientErrorException.class, () -> concertController.buyConcert(genericContainerDto, buyersName));

        assert e.getMessage() != null;
        assert e.getMessage().equals("Could not find the requested concert.");

     }

    @SuppressWarnings("unchecked")
    @Test
    public void testBuyConcertWrongUserName(){

        long id = 0L;
        String buyersName = "Test Name";

        doThrow(new HttpClientErrorException(HttpStatus.BAD_REQUEST, "No user with the provided name found.")).when(concertService).buyConcert(id, buyersName);

        GenericContainerDto<Long> genericContainerDto = mock(GenericContainerDto.class);

        concertController.buyConcert(genericContainerDto, buyersName);

        HttpClientErrorException e = assertThrows(HttpClientErrorException.class, () -> concertController.buyConcert(genericContainerDto, buyersName));

        assert e.getMessage() != null;
        assert e.getMessage().equals("No user with the provided name found.");

    }

    /*
    @SuppressWarnings("unchecked")
    @Test
    public void testGetConcertsOfGenreSuccessful(){

        MusicGenre musicGenre = mock(MusicGenre.class);

        Collection<ConcertDto> concertDtos = mock(Collection.class);

        when(concertService.getConcertsOfGenre(musicGenre).thenReturn(concertDtos);

        assert concertController.getConcertsOfGenre(musicGenre).equals(concertDtos);

    }*/

}
