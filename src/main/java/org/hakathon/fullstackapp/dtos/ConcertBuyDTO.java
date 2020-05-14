package org.hakathon.fullstackapp.dtos;

import org.hakathon.fullstackapp.models.Concert;

public class ConcertBuyDTO {

    private int id;

    public ConcertBuyDTO(){}

    public ConcertBuyDTO(int id){
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
