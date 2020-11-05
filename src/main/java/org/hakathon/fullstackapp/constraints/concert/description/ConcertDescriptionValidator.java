package org.hakathon.fullstackapp.constraints.concert.description;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ConcertDescriptionValidator implements ConstraintValidator<ConcertDescriptionConstraint, String> {

    public static final int MIN_DESCRIPTION_LENGTH = 3;
    public static final int MAX_DESCRIPTION_LENGTH = 20;

    @Override
    public void initialize(ConcertDescriptionConstraint concertDescriptionConstraint) {
    }

    @Override
    public boolean isValid(String description, ConstraintValidatorContext cxt) {
        return description != null && (description.length() >= MIN_DESCRIPTION_LENGTH) &&
                (description.length() <= MAX_DESCRIPTION_LENGTH) && description.matches("[a-zA-Z0-9-_@$!%*?&]+");
    }
}
