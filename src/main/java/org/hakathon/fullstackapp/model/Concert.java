package org.hakathon.fullstackapp.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Time;
import java.util.Calendar;

@Data
@Entity
public class Concert {


    @Id
    @GeneratedValue
    private Long id;

    private Calendar date;
    private String artistName;
    private String concertName;
    private String musicGenre;

    @Lob
    private String imgBase64;

    public Concert() {

    }

    public Concert( Calendar date, String artistName, String concertName, String musicGenre, String imgBase64) {
        this.date = date;
        this.artistName = artistName;
        this.concertName = concertName;
        this.musicGenre = musicGenre;
        this.imgBase64 = imgBase64;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getConcertName(){
        return concertName;
    }

    public void setConcertName(String concertName){
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