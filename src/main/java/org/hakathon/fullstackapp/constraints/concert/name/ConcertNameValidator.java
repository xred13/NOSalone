package org.hakathon.fullstackapp.constraints.concert.name;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ConcertNameValidator implements ConstraintValidator<ConcertNameConstraint, String> {

    public static final int MIN_NAME_LENGTH = 3;
    public static final int MAX_NAME_LENGTH = 20;

    @Override
    public void initialize(ConcertNameConstraint concertNameConstraint) {
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext cxt) {
        return name != null && (name.length() >= MIN_NAME_LENGTH) && (name.length() <= MAX_NAME_LENGTH) && name.matches("[a-zA-Z0-9-_@$!%*?&]+");
    }
}