import React from "react";

const MusicGenreElement = props => {
  return (
    <div
      onClick={() => props.setCurrentGenre(props.genre)}
      className="music-genre-element"
    >
      {props.genre}
    </div>
  );
};

export default MusicGenreElement;
