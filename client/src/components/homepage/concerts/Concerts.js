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
      .get("http://localhost:8080/NosAlone/concert/concerts", { params })
      .then(response => {
        this.setState({
          concerts: response.data
        });
      })
      .catch(response => {
        console.log("oops, something went wrong!");
        console.log(response);

        console.log("inserting default values for concerts");
        this.setState({
          concerts: [
            {
              concertName: "First concert",
              artistName: "Dj jaime",
              musicGenre: "rock",
              date: "30/4/2020",
              imgBase64: "https://i.picsum.photos/id/434/300/200.jpg"
            },
            {
              concertName: "second greatest concert",
              artistName: "Dj Fábio",
              musicGenre: "rock",
              date: "1/5/2020",
              imgBase64: "https://i.picsum.photos/id/790/300/200.jpg"
            },
            {
              concertName: "second greatest concert",
              artistName: "Dj Nunes",
              musicGenre: "rock",
              date: "1/5/2020",
              imgBase64: "https://i.picsum.photos/id/349/300/200.jpg"
            },
            {
              concertName: "second greatest concert",
              artistName: "Dj Marina",
              musicGenre: "jazz",
              date: "1/5/2020",
              imgBase64: "https://i.picsum.photos/id/34/300/200.jpg"
            }
          ]
        });
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
        {this.state.genre != null ? (
          this.state.concerts.map((concertData, i) => (
            <Concert concertData={concertData} removeConcert={this.removeConcert} index={i} key={i} />
          ))
        ) : (
          <div>Sorry, no concerts for this given genre!</div>
        )}
      </div>
    );
  }
}

export default Concerts;
