package org.hakathon.fullstackapp.constraints.concert.img_base_64;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ConcertImgBase64Validator implements ConstraintValidator<ConcertImgBase64Constraint, String> {

    @Override
    public void initialize(ConcertImgBase64Constraint concertImgBase64Constraint) {
    }

    @Override
    public boolean isValid(String imgBase64, ConstraintValidatorContext cxt) {
        return true;
    }
}