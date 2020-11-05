package org.hakathon.fullstackapp.constraints.user.name;

import org.hakathon.fullstackapp.constraints.concert.name.ConcertNameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UserNameValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface UserNameConstraint {
    String message() default "Invalid user name.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
