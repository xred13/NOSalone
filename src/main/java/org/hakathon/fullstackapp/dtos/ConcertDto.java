package org.hakathon.fullstackapp.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hakathon.fullstackapp.models.Concert;

import java.util.Calendar;

@Data
public class ConcertDto {

    private Long id;

    private String name;
    private String description;

    private String musicGenre;

    private int slots;
    private int slotsRemaining;

    private int price;

    private Calendar performanceDate;

    private String imgBase64;

    private String artistName;

}

