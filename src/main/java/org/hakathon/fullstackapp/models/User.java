package org.hakathon.fullstackapp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javassist.expr.Cast;
import lombok.*;
import org.hakathon.fullstackapp.config.AppConfig;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import static org.hakathon.fullstackapp.constraints.user.name.UserNameValidator.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
            nullable = false
    )
    @Length(min = MIN_LENGTH, max = MAX_LENGTH)
    private String name;

    @Column(
            unique = true,
            nullable = false,
            length = 128
    )
    private String email;

    @Column(
            nullable = false
    )
    @Length(
            min = 8,
            max = 128
    )
    private String password;

    @ManyToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @Builder.Default
    private Collection<Concert> boughtConcerts = new ArrayList<>();

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @Builder.Default
    private Collection<Concert> ownedConcerts = new ArrayList<>();

    public void addOwnConcert(Concert concert){
        ownedConcerts.add(concert);
    }

    public void addBoughtConcert(Concert concert){
        boughtConcerts.add(concert);
    }

}
