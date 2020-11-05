package org.hakathon.fullstackapp.constraints.concert.performance_date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

public class ConcertPerformanceDateValidator implements ConstraintValidator<ConcertPerformanceDateConstraint, Calendar> {

    public static final int MIN_PERFORMANCE_HOURS = 12;
    public static final int MIN_PERFORMANCE_DAYS = 0;

    @Override
    public void initialize(ConcertPerformanceDateConstraint performanceDateConstraint) {
    }

    @Override
    public boolean isValid(Calendar performanceDate, ConstraintValidatorContext cxt) {
        return ChronoUnit.HOURS.between(performanceDate.toInstant(), Calendar.getInstance().toInstant()) >= MIN_PERFORMANCE_HOURS + MIN_PERFORMANCE_DAYS * 24;
    }
}