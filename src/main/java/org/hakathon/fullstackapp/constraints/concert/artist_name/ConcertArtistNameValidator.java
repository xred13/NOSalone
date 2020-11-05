package org.hakathon.fullstackapp.constraints.concert.artist_name;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ConcertArtistNameValidator implements ConstraintValidator<ConcertArtistNameConstraint, String> {

    public static final int MIN_NAME_LENGTH = 3;
    public static final int MAX_NAME_LENGTH = 20;

    @Override
    public void initialize(ConcertArtistNameConstraint concertArtistNameConstraint) {
    }

    @Override
    public boolean isValid(String artistName, ConstraintValidatorContext cxt) {
        return artistName != null && (artistName.length() >= MIN_NAME_LENGTH) &&
                (artistName.length() <= MAX_NAME_LENGTH) && artistName.matches("[a-zA-Z0-9-_@$!%*?&]+");
    }
}
