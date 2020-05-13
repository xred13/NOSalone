import React, { Component } from "react";
import axios from "axios";
import ConcertCard from "./../../concert_card/ConcertCard";

class ConcertsBought extends Component {
  state = { concerts: [] };

  componentDidMount() {
    axios.request({
        url: "http://localhost:8080/concerts/get-bought-concerts-of-user",
        method: "GET",
        withCredentials: true
    }).then(response => {
        this.setState({
            concerts: response.data
        })
    }).catch(response => {
        console.log("oops, something went wrong!")
    });
  }

  render() {
    return (
      <div id="myprofile-concertsbought">
        Concerts bought
        <br/>
        {this.state.concerts.length === 0 ? (
          <div id="myprofile-concertsbought-noconcerts">
            It looks like you have no concerts bought!
          </div>
        ) : (
          this.state.concerts.map((concert, i) => (
            <ConcertCard concertData={concert} displayedInProfile={true} key={i} />
          ))
        )}
      </div>
    );
  }
}

export default ConcertsBought;
