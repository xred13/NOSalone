package org.hakathon.fullstackapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Artist {

    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    //private List<Concert> listOfConcerts;

    public Artist() {

    }

    public Artist(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
