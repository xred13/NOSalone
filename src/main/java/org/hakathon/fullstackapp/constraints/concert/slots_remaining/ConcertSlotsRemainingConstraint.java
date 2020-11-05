package org.hakathon.fullstackapp.constraints.concert.slots_remaining;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ConcertSlotsRemainingValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ConcertSlotsRemainingConstraint {
    String message() default "Invalid concert remaining slots.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
