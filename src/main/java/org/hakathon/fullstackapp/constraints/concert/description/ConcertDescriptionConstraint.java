package org.hakathon.fullstackapp.constraints.concert.description;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ConcertDescriptionValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ConcertDescriptionConstraint {
    String message() default "Invalid concert description.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
