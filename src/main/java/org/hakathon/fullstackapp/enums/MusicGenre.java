package org.hakathon.fullstackapp.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public enum MusicGenre {

    CLASSIC,
    ROCK,
    POP,
    CHILL,
    ACOUSTIC,
    ELECTRONIC,
    HIPHOP,
    JAZZ,
    REGGAE,
    SOUL;

    public static boolean exists(String genre) {
        for (MusicGenre musicGenre : values()) {
            if (musicGenre.toString().equals(genre)) return true;
        }

        return false;
    }

    @JsonCreator
    public static MusicGenre convert(String genre) {

        for (MusicGenre musicGenre : values()) {
            if (musicGenre.toString().equals(genre)) return musicGenre;
        }

        // shouldnt reach
        return null;

    }

    @JsonProperty
    @Override
    public String toString() {
        return name().toLowerCase();
    }
}