package org.hakathon.fullstackapp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hakathon.fullstackapp.enums.MusicGenre;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
            nullable = false
    )
    private MusicGenre musicGenre;

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
            mappedBy = "boughtConcerts",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @Builder.Default
    private Collection<User> audienceUsers = new ArrayList<>();

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
        audienceUsers.add(buyer);
        return true;
    }

    public boolean buyable(){
        return slotsRemaining > 0 && performanceDate.compareTo(Calendar.getInstance()) > 0;
    }

}