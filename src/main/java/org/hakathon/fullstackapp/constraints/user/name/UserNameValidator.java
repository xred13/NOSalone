package org.hakathon.fullstackapp.constraints.user.name;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserNameValidator implements ConstraintValidator<UserNameConstraint, String> {

    public static final int MIN_LENGTH = 3;
    public static final int MAX_LENGTH = 15;

    @Override
    public void initialize(UserNameConstraint userName) {
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext cxt) {
        return name != null && (name.length() >= MIN_LENGTH) && (name.length() <= MAX_LENGTH) && name.matches("[a-zA-Z0-9\\-_@$!%*?&]+");
    }
}