package org.hakathon.fullstackapp.constraints.concert.slots;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ConcertSlotsValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ConcertSlotsConstraint {
    String message() default "Invalid concert slots.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
