package org.hakathon.fullstackapp.builders;

import org.hakathon.fullstackapp.dtos.ConcertDto;

import java.util.Calendar;

public class ConcertDtoBuilder {

    private Long id;
    private String name;
    private String description;
    private String musicGenre;
    private int slots;
    private int slotsRemaining;
    private int price;
    private Calendar performanceDate;
    private String artistName;
    private String imgBase64;

    public ConcertDtoBuilder setId(Long id){
        this.id = id;
        return this;
    }

    public ConcertDtoBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ConcertDtoBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public ConcertDtoBuilder setMusicGenre(String musicGenre) {
        this.musicGenre = musicGenre;
        return this;
    }

    public ConcertDtoBuilder setSlots(int slots) {
        this.slots = slots;
        return this;
    }

    public ConcertDtoBuilder setSlotsRemaining(int slotsRemaining) {
        this.slotsRemaining = slotsRemaining;
        return this;
    }

    public ConcertDtoBuilder setPrice(int price) {
        this.price = price;
        return this;
    }

    public ConcertDtoBuilder setPerformanceDate(Calendar performanceDate) {
        this.performanceDate = performanceDate;
        return this;
    }

    public ConcertDtoBuilder setArtistName(String artistName) {
        this.artistName = artistName;
        return this;
    }

    public ConcertDtoBuilder setImgBase64(String imgBase64) {
        this.imgBase64 = imgBase64;
        return this;
    }

    public ConcertDto build(){

        ConcertDto concertDto = new ConcertDto();

        concertDto.setId(id);
        concertDto.setArtistName(artistName);
        concertDto.setName(name);
        concertDto.setDescription(description);
        concertDto.setImgBase64(imgBase64);
        concertDto.setMusicGenre(musicGenre);
        concertDto.setPerformanceDate(performanceDate);
        concertDto.setPrice(price);
        concertDto.setSlots(slots);
        concertDto.setSlotsRemaining(slotsRemaining);

        return concertDto;
    }

}
