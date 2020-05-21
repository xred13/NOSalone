package org.hakathon.fullstackapp.builders;

import org.hakathon.fullstackapp.dtos.ConcertDto;
import org.hakathon.fullstackapp.models.Concert;
import org.hakathon.fullstackapp.models.User;

import java.util.Calendar;

public class ConcertBuilder {

    private String name;
    private String description;
    private String musicGenre;
    private int slots;
    private int slotsRemaining;
    private int price;
    private Calendar performanceDate;
    private String imgBase64;
    private User artist;


    public ConcertBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ConcertBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public ConcertBuilder setMusicGenre(String musicGenre) {
        this.musicGenre = musicGenre;
        return this;
    }

    public ConcertBuilder setSlots(int slots) {
        this.slots = slots;
        return this;
    }

    public ConcertBuilder setSlotsRemaining(int slotsRemaining) {
        this.slotsRemaining = slotsRemaining;
        return this;
    }

    public ConcertBuilder setPrice(int price) {
        this.price = price;
        return this;
    }

    public ConcertBuilder setPerformanceDate(Calendar performanceDate) {
        this.performanceDate = performanceDate;
        return this;
    }

    public ConcertBuilder setImgBase64(String imgBase64) {
        this.imgBase64 = imgBase64;
        return this;
    }

    public ConcertBuilder setArtist(User artist){
        this.artist = artist;
        return this;
    }

    public Concert build(){

        Concert concert = new Concert();

        concert.setName(name);
        concert.setDescription(description);
        concert.setImgBase64(imgBase64);
        concert.setMusicGenre(musicGenre);
        concert.setPerformanceDate(performanceDate);
        concert.setPrice(price);
        concert.setSlots(slots);
        concert.setSlotsRemaining(slotsRemaining);
        concert.setArtist(artist);

        return concert;
    }

}
