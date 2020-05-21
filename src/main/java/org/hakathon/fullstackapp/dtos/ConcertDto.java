package org.hakathon.fullstackapp.dtos;

import lombok.*;
import org.hakathon.fullstackapp.enums.MusicGenre;
import org.hakathon.fullstackapp.models.Concert;

import java.util.Calendar;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ConcertDto {

    private Long id;

    private String name;
    private String description;

    private MusicGenre musicGenre;

    private int slots;
    private int slotsRemaining;

    private int price;

    private Calendar performanceDate;

    private String imgBase64;

    private String artistName;

}

