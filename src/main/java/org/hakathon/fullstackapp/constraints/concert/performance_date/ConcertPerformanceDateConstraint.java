package org.hakathon.fullstackapp.constraints.concert.performance_date;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ConcertPerformanceDateValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ConcertPerformanceDateConstraint {
    String message() default "Invalid concert performance date.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
