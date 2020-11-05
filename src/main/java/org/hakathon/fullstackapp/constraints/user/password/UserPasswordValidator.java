package org.hakathon.fullstackapp.constraints.user.password;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserPasswordValidator implements ConstraintValidator<UserPasswordConstraint, String> {

    public static final int MIN_LENGTH = 5;
    public static final int MAX_LENGTH = 128;

    public static final String PASSWORD_REGEX = "[a-zA-Z0-9\\-_@$!%*?& ]{" + MIN_LENGTH + "," + MAX_LENGTH + "}";

    @Override
    public void initialize(UserPasswordConstraint passwordConstraint) {
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext cxt) {
        return password != null && password.matches(PASSWORD_REGEX);
    }
}