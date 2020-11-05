package org.hakathon.fullstackapp.converters;

import org.hakathon.fullstackapp.dtos.sent.ConcertDto;
import org.hakathon.fullstackapp.models.Concert;

public class ConcertToConcertDtoConverter {

    public static ConcertDto convert(Concert concert){
        return ConcertDto.builder()
                .id(concert.getId())
                .artistName(concert.getArtist() != null ? concert.getArtist().getName() : null)
                .name(concert.getName())
                .description(concert.getDescription())
                .imgBase64(concert.getImgBase64())
                .musicGenre(concert.getMusicGenre())
                .performanceDate(concert.getPerformanceDate())
                .price(concert.getPrice())
                .slots(concert.getSlots())
                .slotsRemaining(concert.getSlotsRemaining())
                .build();
    }

}
