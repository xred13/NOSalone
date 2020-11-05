package org.hakathon.fullstackapp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hakathon.fullstackapp.constraints.concert.description.ConcertDescriptionValidator;
import org.hakathon.fullstackapp.constraints.concert.name.ConcertNameValidator;
import org.hakathon.fullstackapp.constraints.concert.price.ConcertPriceValidator;
import org.hakathon.fullstackapp.constraints.concert.slots.ConcertSlotsValidator;
import org.hakathon.fullstackapp.constraints.concert.slots_remaining.ConcertSlotsRemainingValidator;
import org.hakathon.fullstackapp.enums.MusicGenre;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Min;
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
            nullable = false
    )
    @Length(min = ConcertNameValidator.MIN_NAME_LENGTH, max = ConcertNameValidator.MAX_NAME_LENGTH)
    private String name;

    @Column(
            nullable = false
    )
    @Length(min = ConcertDescriptionValidator.MIN_DESCRIPTION_LENGTH, max = ConcertDescriptionValidator.MAX_DESCRIPTION_LENGTH)
    private String description;

    @Column(
            nullable = false
    )
    private MusicGenre musicGenre;

    @Range(min = ConcertSlotsValidator.MIN_SLOTS_VALUE, max = ConcertSlotsValidator.MAX_SLOTS_VALUE)
    private int slots;

    @Range(min = ConcertSlotsRemainingValidator.MIN_SLOTS_REMAINING, max = ConcertSlotsRemainingValidator.MAX_SLOTS_REMAINING)
    private int slotsRemaining;

    @Column(
            nullable = false
    )
    @Range(min = ConcertPriceValidator.MIN_PRICE, max = ConcertPriceValidator.MAX_PRICE)
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