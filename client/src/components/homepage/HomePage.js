import React, { Component } from "react";
import MusicGenres from "./music_genres/MusicGenres";
import "./../../sass/homepage//Homepage.scss";
import Concerts from "./concerts/Concerts";

class HomePage extends Component {
  state = {
    genres: ["acoustic", "chill", "classic", "rock", "reggae", "soul", "jazz", "electronic", "pop", "hiphop"],
    currentGenre: "classic"
  };

  setCurrentGenre = genre => {
    this.setState({
      currentGenre: genre
    });
  };

  render() {
    return (
      <div id="homepage">
        <MusicGenres
          className="music-genres"
          setCurrentGenre={this.setCurrentGenre}
        />
        <Concerts currentGenre={this.state.currentGenre} />
      </div>
    );
  }
}

export default HomePage;
