package org.hakathon.fullstackapp.constraints.concert.img_base_64;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ConcertImgBase64Validator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ConcertImgBase64Constraint {
    String message() default "Invalid concert image base 64.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
