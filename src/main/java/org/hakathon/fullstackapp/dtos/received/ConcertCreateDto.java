package org.hakathon.fullstackapp.dtos.received;

import lombok.*;
import org.hakathon.fullstackapp.constraints.concert.artist_name.ConcertArtistNameConstraint;
import org.hakathon.fullstackapp.constraints.concert.description.ConcertDescriptionConstraint;
import org.hakathon.fullstackapp.constraints.concert.img_base_64.ConcertImgBase64Constraint;
import org.hakathon.fullstackapp.constraints.concert.music_genre.ConcertMusicGenreConstraint;
import org.hakathon.fullstackapp.constraints.concert.name.ConcertNameConstraint;
import org.hakathon.fullstackapp.constraints.concert.performance_date.ConcertPerformanceDateConstraint;
import org.hakathon.fullstackapp.constraints.concert.price.ConcertPriceConstraint;
import org.hakathon.fullstackapp.constraints.concert.slots.ConcertSlotsConstraint;
import org.hakathon.fullstackapp.constraints.concert.slots_remaining.ConcertSlotsRemainingConstraint;
import org.hakathon.fullstackapp.enums.MusicGenre;
import org.springframework.validation.annotation.Validated;

import java.util.Calendar;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Validated
public class ConcertCreateDto {

    @ConcertNameConstraint
    private String name;

    @ConcertDescriptionConstraint
    private String description;

    @ConcertMusicGenreConstraint
    private MusicGenre musicGenre;

    @ConcertSlotsConstraint
    private int slots;

    @ConcertSlotsRemainingConstraint
    private int slotsRemaining;

    @ConcertPriceConstraint
    private int price;

    @ConcertPerformanceDateConstraint
    private Calendar performanceDate;

    @ConcertImgBase64Constraint
    private String imgBase64;

    @ConcertArtistNameConstraint
    private String artistName;

}