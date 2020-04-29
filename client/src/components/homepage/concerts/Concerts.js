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
              date: "30/4/2020",
              numberMaxFans: 6,
              imgBase64: "https://i.picsum.photos/id/434/300/200.jpg"
            },
            {
              concertName: "second greatest concert",
              artistName: "Dj Fábio",
              date: "1/5/2020",
              numberMaxFans: 1,
              imgBase64: "https://i.picsum.photos/id/790/300/200.jpg"
            },
            {
              concertName: "second greatest concert",
              artistName: "Dj Nunes",
              date: "1/5/2020",
              numberMaxFans: 1,
              imgBase64: "https://i.picsum.photos/id/349/300/200.jpg"
            },
            {
              concertName: "second greatest concert",
              artistName: "Dj Marina",
              date: "1/5/2020",
              numberMaxFans: 1,
              imgBase64: "https://i.picsum.photos/id/34/300/200.jpg"
            }
          ]
        });
      });
  };

  render() {
    return (
      <div id="concerts">
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
