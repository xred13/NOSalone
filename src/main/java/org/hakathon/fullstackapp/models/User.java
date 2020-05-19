package org.hakathon.fullstackapp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javassist.expr.Cast;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

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

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Collection<Concert> concertsBought = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Collection<Concert> concertsOwned = new ArrayList<>();

    public User(){

    }

    public User(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Concert> getConcertsBought() {
        return concertsBought;
    }

    public void setConcertsBought(Collection<Concert> concertsBought) {
        this.concertsBought = concertsBought;
    }

    public Collection<Concert> getConcertsOwned() {
        return concertsOwned;
    }

    public void setConcertsOwned(Collection<Concert> concertsOwned) {
        this.concertsOwned = concertsOwned;
    }

    public void buyConcert(Concert concert){
        concertsBought.add(concert);
    }

    public void addOwnConcert(Concert concert){
        concertsOwned.add(concert);
    }
}
