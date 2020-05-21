package org.hakathon.fullstackapp.dtos;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {

    private String name;
    private String password;
    private String email;

}
