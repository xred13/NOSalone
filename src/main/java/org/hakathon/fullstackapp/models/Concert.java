package org.hakathon.fullstackapp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

@Data
@Entity
@JsonIgnoreProperties({"artist", "audience"})
public class Concert {


    @Id
    @GeneratedValue
    private Long id;

    private String concertName;
    private String description;

    private String musicGenre;

    private int slots;
    private int slotsRemaining;

    private int price;

    private Calendar performanceDate;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private User artist;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Collection<User> audience = new ArrayList<>();

    @Lob
    private String imgBase64;

    public Concert(){

    }

    public Concert(String concertName, String description, String musicGenre, int slots, int price, Calendar performanceDate, User artist, String imgBase64){
        this.concertName = concertName;
        this.description = description;
        this.musicGenre = musicGenre;
        this.slots = slots;
        this.slotsRemaining = slots;
        this.price = price;
        this.performanceDate = performanceDate;
        this.artist = artist;
        this.imgBase64 = imgBase64;
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

    public void decrementSlotsRemaining(){
        this.slotsRemaining--;
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

    public User getArtist() {
        return artist;
    }

    public void setArtist(User artist) {
        this.artist = artist;
    }

    public Collection<User> getAudience() {
        return audience;
    }

    public void setAudience(Collection<User> audience) {
        this.audience = audience;
    }

    public String getImgBase64() {
        return imgBase64;
    }

    public void setImgBase64(String imgBase64) {
        this.imgBase64 = imgBase64;
    }

    public boolean buy(User buyer){

        if(!isBuyable()){
            return false;
        }

        decrementSlotsRemaining();
        audience.add(buyer);
        return true;
    }

    public boolean isBuyable(){
        return getSlotsRemaining() > 0 && getPerformanceDate().compareTo(Calendar.getInstance()) > 0;
    }


}