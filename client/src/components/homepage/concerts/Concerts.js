import React, { Component } from "react";
import ConcertCard from "../../concert_card/ConcertCard";
import axios from "axios";
import "./../../../sass/homepage/concerts/Concerts.scss";

class Concerts extends Component {
  state = {
    genre: null,
    concerts: [],
  };

  componentDidMount(){
    this.setState({
      genre: this.props.currentGenre
    },
      this.getConcertsOfGenre
    )
  }

  componentWillReceiveProps(nextProps){
    if (nextProps.currentGenre === null) {
      return;
    }

    this.setState({
      genre: nextProps.currentGenre
    }, 
      this.getConcertsOfGenre
    )
  };

  getConcertsOfGenre = () => {
    axios
      .request({
        url: "http://localhost:8080/concerts/get-concerts-of-genre",
        method: "POST",

        headers: {
          "Content-Type": "application/json",
        },

        data: {
          data: this.state.genre
        },
      })
      .then((response) => {
        console.log("Fetched concerts of genre successfully!");

        this.setState({
          concerts: response.data,
        });
      })
      .catch((response) => {
        console.log("Something went wrong!");
      });
  };

  removeConcert = (index) => {
    let concertsUpdated = this.state.concerts;

    concertsUpdated.splice(index, 1);

    this.setState({
      concerts: concertsUpdated,
    });
  };

  render() {
    return (
      <div id="concerts">
        {this.state.concerts.length !== 0 ? (
          this.state.concerts.map((concertData, i) => (
            <ConcertCard
              concertData={concertData}
              displayedInProfile={false}
              removeConcert={this.removeConcert}
              index={i}
              key={i}
            />
          ))
        ) : (
          <div id="no-concerts-warning">
            Sorry, no concerts for this given genre!
          </div>
        )}
      </div>
    );
  }
}

export default Concerts;
