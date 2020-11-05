package org.hakathon.fullstackapp.dtos.received;

import lombok.*;
import org.hakathon.fullstackapp.constraints.user.name.UserNameConstraint;
import org.hakathon.fullstackapp.constraints.user.password.UserPasswordConstraint;
import org.springframework.validation.annotation.Validated;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Validated
public class UserUsernameLoginDto {

    @UserNameConstraint
    private String name;

    @UserPasswordConstraint
    private String password;


}
