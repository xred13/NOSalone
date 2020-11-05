package org.hakathon.fullstackapp.constraints.concert.music_genre;

import org.hakathon.fullstackapp.enums.MusicGenre;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ConcertMusicGenreValidator implements ConstraintValidator<ConcertMusicGenreConstraint, MusicGenre> {

    @Override
    public void initialize(ConcertMusicGenreConstraint concertMusicGenreConstraint) {
    }

    @Override
    public boolean isValid(MusicGenre musicGenre, ConstraintValidatorContext cxt) {
        return musicGenre != null;
    }
}