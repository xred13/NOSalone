package org.hakathon.fullstackapp.constraints.concert.price;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ConcertPriceValidator implements ConstraintValidator<ConcertPriceConstraint, Integer> {

    public static final int MIN_PRICE = 0;
    public static final int MAX_PRICE = 100;

    @Override
    public void initialize(ConcertPriceConstraint concertPriceConstraint) {
    }

    @Override
    public boolean isValid(Integer price, ConstraintValidatorContext cxt) {
        return price >= MIN_PRICE && price <= MAX_PRICE;
    }
}