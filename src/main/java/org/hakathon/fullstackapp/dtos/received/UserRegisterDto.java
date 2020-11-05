package org.hakathon.fullstackapp.dtos.received;

import lombok.*;
import org.hakathon.fullstackapp.constraints.user.email.UserEmailConstraint;
import org.hakathon.fullstackapp.constraints.user.name.UserNameConstraint;
import org.hakathon.fullstackapp.constraints.user.password.UserPasswordConstraint;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Validated
public class UserRegisterDto {

    @UserNameConstraint
    private String name;

    @UserPasswordConstraint
    private String password;

    @UserEmailConstraint
    private String email;

}
