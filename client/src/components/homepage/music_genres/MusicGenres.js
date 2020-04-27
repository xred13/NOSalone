import React from "react";
import axios from "axios";
import MusicGenreElement from "./MusicGenreElement";

const MusicGenres = (props) => {
  return (
    <div id="music-genres">
      {props.genres.map((genre, i) => (
        <MusicGenreElement setCurrentGenre={props.setCurrentGenre} genre={genre} key={i} />
      ))}
    </div>
  );
};

export default MusicGenres;
