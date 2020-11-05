package org.hakathon.fullstackapp.constraints.user.email;

import org.hakathon.fullstackapp.constraints.concert.name.ConcertNameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UserEmailValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface UserEmailConstraint {
    String message() default "Invalid user email.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
