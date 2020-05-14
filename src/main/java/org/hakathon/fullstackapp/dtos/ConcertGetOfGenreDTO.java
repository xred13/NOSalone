package org.hakathon.fullstackapp.dtos;

import org.hakathon.fullstackapp.models.Concert;

public class ConcertGetOfGenreDTO {

    private String genre;

    public ConcertGetOfGenreDTO(){

    }

    public ConcertGetOfGenreDTO(String genre){
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
