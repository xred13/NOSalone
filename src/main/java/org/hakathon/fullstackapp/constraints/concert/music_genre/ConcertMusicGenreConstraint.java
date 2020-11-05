package org.hakathon.fullstackapp.constraints.concert.music_genre;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ConcertMusicGenreValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ConcertMusicGenreConstraint {
    String message() default "Invalid concert music genre.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
