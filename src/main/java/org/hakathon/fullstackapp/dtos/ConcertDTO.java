package org.hakathon.fullstackapp.dtos;

import org.hakathon.fullstackapp.model.Concert;

import javax.persistence.Lob;
import java.sql.Time;
import java.util.Calendar;

public class ConcertDTO {

    private Calendar date;
    private Integer numberMaxFans;
    private String artistName;
    private String concertName;

    private String musicGenre;
    private String imgBase64;

    public ConcertDTO(){}

    public ConcertDTO(Calendar date, Integer numberMaxFans, String artistName, String concertName, String musicGenre, String imgBase64){
        this.date = date;
        this.numberMaxFans = numberMaxFans;
        this.artistName = artistName;
        this.concertName = concertName;
        this.musicGenre = musicGenre;
        this.imgBase64 = imgBase64;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public Integer getNumberMaxFans() {
        return numberMaxFans;
    }

    public void setNumberMaxFans(Integer numberMaxFans) {
        this.numberMaxFans = numberMaxFans;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getConcertName() {
        return concertName;
    }

    public void setConcertName(String concertName) {
        this.concertName = concertName;
    }

    public String getMusicGenre() {
        return musicGenre;
    }

    public void setMusicGenre(String musicGenre) {
        this.musicGenre = musicGenre;
    }

    public String getImgBase64() {
        return imgBase64;
    }

    public void setImgBase64(String imgBase64) {
        this.imgBase64 = imgBase64;
    }
}
