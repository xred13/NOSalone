package org.hakathon.fullstackapp.dtos;

import lombok.Data;

@Data
public class GenericContainerDto<T> {

    private T data;

}
