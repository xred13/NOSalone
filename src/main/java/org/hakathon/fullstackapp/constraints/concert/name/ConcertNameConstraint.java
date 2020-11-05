package org.hakathon.fullstackapp.constraints.concert.name;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ConcertNameValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ConcertNameConstraint {
    String message() default "Invalid concert name.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
