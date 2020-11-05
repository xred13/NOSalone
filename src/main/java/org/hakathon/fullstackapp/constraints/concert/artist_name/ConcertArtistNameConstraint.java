package org.hakathon.fullstackapp.constraints.concert.artist_name;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ConcertArtistNameValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ConcertArtistNameConstraint {
    String message() default "Invalid concert artist name.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
