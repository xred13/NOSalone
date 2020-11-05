package org.hakathon.fullstackapp.constraints.user.password;

import org.hakathon.fullstackapp.constraints.concert.name.ConcertNameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UserPasswordValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface UserPasswordConstraint {
    String message() default "Invalid user password.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
