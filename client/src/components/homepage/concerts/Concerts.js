import React, { Component } from "react";
import Concert from "./Concert";
import axios from "axios";
import NewConcert from "./NewConcert";
import "./../../../sass/homepage/concerts/NewConcert.scss";

class Concerts extends Component {
  state = {
    genre: null,
    concerts: []
  };

  componentWillReceiveProps(nextProps) {
    console.log("Received props");
    console.log(nextProps);

    this.setState({
      genre: nextProps.currentGenre
    });

    axios
      .get("http://localhost:8080/NosAlone/concert/concerts")
      .then(response => {
        this.setState({
          concerts: response.data
        });
      })
      .catch(response => {
        console.log("oops, something went wrong!");

        console.log("inserting default values for concerts");
        this.setState({
          concerts: [
            {
              concertName: "First concert",
              artistName: "Dj jaime",
              date: "30/4/2020",
              slots: 6,
              image: "https://i.picsum.photos/id/434/300/200.jpg"
            },
            {
              concertName: "second greatest concert",
              artistName: "Dj Fábio",
              date: "1/5/2020",
              slots: 1,
              image: "https://i.picsum.photos/id/790/300/200.jpg"
            },
            {
              concertName: "second greatest concert",
              artistName: "Dj Nunes",
              date: "1/5/2020",
              slots: 1,
              image: "https://i.picsum.photos/id/349/300/200.jpg"
            },
            {
              concertName: "second greatest concert",
              artistName: "Dj Marina",
              date: "1/5/2020",
              slots: 1,
              image: "https://i.picsum.photos/id/34/300/200.jpg"
            }
          ]
        });
      });
  }

  render() {
    return (
      <div id="concerts">
        <NewConcert />

        {this.state.genre != null ? (
          this.state.concerts.map((concertData, i) => (
            <Concert concertData={concertData} key={i} />
          ))
        ) : (
          <div>Sorry, no concerts for this given genre!</div>
        )}
      </div>
    );
  }
}

export default Concerts;
