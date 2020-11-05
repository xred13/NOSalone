package org.hakathon.fullstackapp.constraints.concert.price;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ConcertPriceValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ConcertPriceConstraint {
    String message() default "Invalid concert price.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
