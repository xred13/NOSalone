package org.hakathon.fullstackapp.dtos.received;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GenericContainerDto<T> {

    private T data;

}
