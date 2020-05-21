package org.hakathon.fullstackapp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

@Data
@Entity
@Table
@JsonIgnoreProperties({"artist", "audience"})
public class Concert {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private long version;

    @Column(
            length = 20,
            nullable = false
    )
    private String name;
    @Column(
            length = 200,
            nullable = false
    )
    private String description;

    @Column(
            length = 20,
            nullable = false
    )
    private String musicGenre;

    private int slots;
    private int slotsRemaining;

    @Column(
            nullable = false
    )
    private int price;

    @Column(
            nullable = false
    )
    private Calendar performanceDate;

    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private User artist;

    @ManyToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private Collection<User> audience = new ArrayList<>();

    @Lob
    @Column(
            nullable = false
    )
    private String imgBase64;

    public boolean buy(User buyer){

        if(!buyable()){
            return false;
        }

        slotsRemaining--;
        audience.add(buyer);
        return true;
    }

    public boolean buyable(){
        return slotsRemaining > 0 && performanceDate.compareTo(Calendar.getInstance()) > 0;
    }


}