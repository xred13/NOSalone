import React, { Component } from "react";
import Concert from "./Concert";
import axios from "axios";
import "./../../../sass/homepage/concerts/Concerts.scss";

class Concerts extends Component {
  state = {
    genre: null,
    concerts: []
  };

  componentWillReceiveProps = nextProps => {
    if (nextProps.currentGenre === null) {
      return;
    }

    this.setState({
      genre: nextProps.currentGenre
    });

    let params = {
      musicGenre: nextProps.currentGenre
    };

    axios
      .get("http://localhost:8080/concerts/get-concerts-of-genre", { params })
      .then(response => {
        this.setState({
          concerts: response.data
        });
      })
      .catch(response => {
        console.log("oops, something went wrong!");
        console.log(response);
      });
  };

  removeConcert = (index) => {

    let concertsUpdated = this.state.concerts

    concertsUpdated.splice(index, 1);

    this.setState({
      concerts: concertsUpdated
    })
  }

  render() {
    return (
      <div id="concerts">
        {this.state.concerts.length !== 0 ? (
          this.state.concerts.map((concertData, i) => (
            <Concert concertData={concertData} removeConcert={this.removeConcert} index={i} key={i} />
          ))
        ) : (
          <div id="no-concerts-warning">Sorry, no concerts for this given genre!</div>
        )}
      </div>
    );
  }
}

export default Concerts;
