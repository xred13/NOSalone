package org.hakathon.fullstackapp.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Calendar;

@Data
@Entity
public class Concert {


    @Id
    @GeneratedValue
    private Long id;
    //private Artist artist;
    private Calendar date;
    private Integer numberMaxFans;
    private String name;
    private String musicGenre;
    private String imgURL;

    public Concert() {

    }

    public Concert( /*Artist artist,*/ Integer year, Integer month, Integer day, Integer hour, Integer minute, Integer numberMaxFans, String name, String musicGenre, String imgURL) {
        //this.artist = artist;
        this.date = Calendar.getInstance();
        date.set(year, month, day,hour, minute);
        this.numberMaxFans = numberMaxFans;
        this.name = name;
        this.musicGenre = musicGenre;
        this.imgURL = imgURL;
    }
}