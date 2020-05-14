import React, { Component } from "react";
import ConcertCard from "./../../concert_card/ConcertCard";
import axios from "axios";

class MyConcerts extends Component {
  state = {
    concerts: [],
  };

  componentDidMount() {
    axios.request({
        url: "http://localhost:8080/concerts/get-owned-concerts-of-user",
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
      <div id="myprofile-myconcerts">
        My Concerts
        <br/>
        {this.state.concerts.length === 0
          ? <div id="myprofile-myconcerts-noconcerts">It looks like you have no concert of your own!</div>
          : 
          this.state.concerts.map((concert, i) => (
            <ConcertCard concertData={concert} displayedInProfile={true} key={i}/>
          ))}
      </div>
    );
  }
}

export default MyConcerts;
