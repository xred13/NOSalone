package org.hakathon.fullstackapp.converters;

import org.hakathon.fullstackapp.dtos.ConcertDto;
import org.hakathon.fullstackapp.models.Concert;

public class ConcertDtoToConcertConverter {

    public static Concert convert(ConcertDto concertDto){
        return Concert.builder()
                .name(concertDto.getName())
                .description(concertDto.getDescription())
                .imgBase64(concertDto.getImgBase64())
                .musicGenre(concertDto.getMusicGenre())
                .performanceDate(concertDto.getPerformanceDate())
                .price(concertDto.getPrice())
                .slots(concertDto.getSlots())
                .slotsRemaining(concertDto.getSlotsRemaining())
                .build();
    }

}
