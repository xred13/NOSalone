package org.hakathon.fullstackapp.constraints.concert.slots;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ConcertSlotsValidator implements ConstraintValidator<ConcertSlotsConstraint, Integer> {

    public static final int MIN_SLOTS_VALUE = 1;
    public static final int MAX_SLOTS_VALUE = Integer.MAX_VALUE;

    @Override
    public void initialize(ConcertSlotsConstraint concertSlotsConstraint) {
    }

    @Override
    public boolean isValid(Integer slots, ConstraintValidatorContext cxt) {
        return slots >= MIN_SLOTS_VALUE && slots <= MAX_SLOTS_VALUE;
    }
}