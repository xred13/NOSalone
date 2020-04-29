package org.hakathon.fullstackapp.dtos;

import org.hakathon.fullstackapp.model.Concert;

import javax.persistence.Lob;
import java.sql.Time;
import java.util.Calendar;

public class ConcertDTO {

    private Calendar date;
    private String artistName;
    private String concertName;
    private String description;
    private int price;

    private String musicGenre;
    private String imgBase64;

    public ConcertDTO(){}

    public ConcertDTO(Calendar date, String artistName, String concertName, String description, int price, String musicGenre, String imgBase64){
        this.description = description;
        this.price = price;
        this.date = date;
        this.artistName = artistName;
        this.concertName = concertName;
        this.musicGenre = musicGenre;
        this.imgBase64 = imgBase64;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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
