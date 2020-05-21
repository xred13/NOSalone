package org.hakathon.fullstackapp.dtos.concert;

import org.hakathon.fullstackapp.models.Concert;

import java.util.Calendar;

public class ConcertDto {

    private Long id;

    private String concertName;
    private String description;

    private String musicGenre;

    private int slots;
    private int slotsRemaining;

    private int price;

    private Calendar performanceDate;

    private String imgBase64;

    private String artistName;

    public ConcertDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConcertName() {
        return concertName;
    }

    public void setConcertName(String concertName) {
        this.concertName = concertName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMusicGenre() {
        return musicGenre;
    }

    public void setMusicGenre(String musicGenre) {
        this.musicGenre = musicGenre;
    }

    public int getSlots() {
        return slots;
    }

    public void setSlots(int slots) {
        this.slots = slots;
    }

    public int getSlotsRemaining() {
        return slotsRemaining;
    }

    public void setSlotsRemaining(int slotsRemaining) {
        this.slotsRemaining = slotsRemaining;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Calendar getPerformanceDate() {
        return performanceDate;
    }

    public void setPerformanceDate(Calendar performanceDate) {
        this.performanceDate = performanceDate;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getImgBase64() {
        return imgBase64;
    }

    public void setImgBase64(String imgBase64) {
        this.imgBase64 = imgBase64;
    }

}

