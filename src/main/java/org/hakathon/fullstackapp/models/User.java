package org.hakathon.fullstackapp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javassist.expr.Cast;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Data
@Entity
@Table(
        name = "users",
        indexes = {
                @Index(columnList = "name", name = "users_name")
        }
)
@JsonIgnoreProperties({"concertsBought", "concertsOwned"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Version
    private long version;

    @Column(
            unique = true,
            nullable = false,
            length = 15
    )
    private String name;

    @Column(
            unique = true,
            nullable = false,
            length = 128
    )
    private String email;

    @Column(
            nullable = false,
            length = 128
    )
    private String password;

    @ManyToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private Collection<Concert> concertsBought = new ArrayList<>();

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private Collection<Concert> concertsOwned = new ArrayList<>();

    public void addOwnConcert(Concert concert){
        getConcertsOwned().add(concert);
    }

    public void addBoughtConcert(Concert concert){
        getConcertsBought().add(concert);
    }

}
