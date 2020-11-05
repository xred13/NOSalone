package org.hakathon.fullstackapp.constraints.concert.slots_remaining;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ConcertSlotsRemainingValidator implements ConstraintValidator<ConcertSlotsRemainingConstraint, Integer> {

    public static final int MIN_SLOTS_REMAINING = 0;
    public static final int MAX_SLOTS_REMAINING = Integer.MAX_VALUE;

    @Override
    public void initialize(ConcertSlotsRemainingConstraint concertSlotsRemainingConstraint) {
    }

    @Override
    public boolean isValid(Integer slotsRemaining, ConstraintValidatorContext cxt) {
        return slotsRemaining >= MIN_SLOTS_REMAINING && slotsRemaining <= MAX_SLOTS_REMAINING;
    }
}