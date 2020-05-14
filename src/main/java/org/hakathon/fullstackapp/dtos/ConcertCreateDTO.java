package org.hakathon.fullstackapp.dtos;

import java.util.Calendar;

public class ConcertCreateDTO {

    private String concertName;
    private String description;

    private String musicGenre;

    private int slots;

    private int price;

    private Calendar performanceDate;

    private String imgBase64;

    public ConcertCreateDTO(){}

    public ConcertCreateDTO(String concertName, String description, String musicGenre, int slots, int price, Calendar performanceDate, String imgBase64) {
        this.concertName = concertName;
        this.description = description;
        this.musicGenre = musicGenre;
        this.slots = slots;
        this.price = price;
        this.performanceDate = performanceDate;
        this.imgBase64 = imgBase64;
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

    public String getImgBase64() {
        return imgBase64;
    }

    public void setImgBase64(String imgBase64) {
        this.imgBase64 = imgBase64;
    }
}
