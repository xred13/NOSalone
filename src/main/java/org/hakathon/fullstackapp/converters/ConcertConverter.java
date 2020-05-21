package org.hakathon.fullstackapp.converters;

import org.hakathon.fullstackapp.builders.ConcertBuilder;
import org.hakathon.fullstackapp.builders.ConcertDtoBuilder;
import org.hakathon.fullstackapp.dtos.ConcertDto;
import org.hakathon.fullstackapp.models.Concert;

public class ConcertConverter {

    public static Concert convert(ConcertDto concertDto){
        return new ConcertBuilder()
                .setName(concertDto.getName())
                .setDescription(concertDto.getDescription())
                .setImgBase64(concertDto.getImgBase64())
                .setMusicGenre(concertDto.getMusicGenre())
                .setPerformanceDate(concertDto.getPerformanceDate())
                .setPrice(concertDto.getPrice())
                .setSlots(concertDto.getSlots())
                .setSlotsRemaining(concertDto.getSlotsRemaining())
                .build();
    }

    public static ConcertDto convert(Concert concert){
        return new ConcertDtoBuilder()
                .setId(concert.getId())
                .setArtistName(concert.getArtist() != null ? concert.getArtist().getName() : null)
                .setName(concert.getName())
                .setDescription(concert.getDescription())
                .setImgBase64(concert.getImgBase64())
                .setMusicGenre(concert.getMusicGenre())
                .setPerformanceDate(concert.getPerformanceDate())
                .setPrice(concert.getPrice())
                .setSlots(concert.getSlots())
                .setSlotsRemaining(concert.getSlotsRemaining())
                .build();
    }

}
