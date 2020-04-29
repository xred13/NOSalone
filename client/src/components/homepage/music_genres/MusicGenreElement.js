import React from "react";

const MusicGenreElement = props => {
  return (
    <div onClick={() => props.setCurrentGenre(props.genre)}>
      <img src="https://i.picsum.photos/id/36/200/200.jpg" />
    </div>
  );
};

export default MusicGenreElement;
