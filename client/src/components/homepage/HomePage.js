import React, { Component } from "react";
import MusicGenres from "./music_genres/MusicGenres";
import "./../../sass/homepage//Homepage.scss";
import Concerts from "./concerts/Concerts";
import axios from "axios";

class HomePage extends Component {
  state = {
    genres: [],
    currentGenre: null
  };

  setCurrentGenre = genre => {
    this.setState({
      currentGenre: genre
    });
  };

  async componentDidMount() {
    await axios
      .get("http://localhost:8080/NosAlone/concert/musicGenre")
      .then(response => {
        this.setState({
          genres: response.data
        });
      })
      .catch(response => {
        console.log("Oops, something went wrong!");
        console.log(response);

        console.log("Initializing genres with default values");
        this.setState({
          genres: [
            "rock",
            "pop",
            "electric",
            "piano",
            "guitar",
            "metal",
            "something"
          ]
        });
      });

    if (this.state.genres.length > 0) {
      this.setCurrentGenre(this.state.genres[0]);
    }
  }

  render() {
    return (
      <div id="homepage">
        <MusicGenres
          className="music-genres"
          setCurrentGenre={this.setCurrentGenre}
          genres={this.state.genres}
        />
        <Concerts currentGenre={this.state.currentGenre} />
      </div>
    );
  }
}

export default HomePage;
