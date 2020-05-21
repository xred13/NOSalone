import React, { Component } from "react";
import "./../../sass/concert_card/ConcertCard.scss";
import axios from "axios";

class ConcertCard extends Component {
  state = {
    artistName: "",
    concertName: "",
    description: "",
    performanceDate: null,
    price: 0,
    slots: null,
    slotsRemaining: null,
    imgBase64: null,
    id: null,
  };

  componentDidMount() {
    this.setState({
      ...this.props.concertData,
    });
  }

  buyConcert = () => {
    axios.request({
      url: "http://localhost:8080/concerts/buy",
      method: "POST",
      withCredentials: true,

      data:{
        data: this.state.id
      }
    }).then(response => {
      alert("Bought concert successfully!")
    }).catch(error => {
      alert("oops.... something has occurred!")
    })
  }

  render() {
    return (
      <div className="concert-card">
        <div className="concert-card-date">
          {" "}
          {this.state.performanceDate != null
            ? this.state.performanceDate.substring(0, 19)
            : null}
        </div>
        <div className="concert-card-concertname">{this.state.concertName}</div>
        <div className="concert-card-artistname">{this.state.artistName}</div>
        <div className="concert-card-image-wrapper">
          <img className="concert-card-image" src={this.state.imgBase64} />
        </div>

        <div className="concert-card-description">{this.state.description}</div>
        <div className="concert-card-slots">
          There are currently {this.state.slotsRemaining} / {this.state.slots}{" "}
          slots remaining!
        </div>
        <button onClick={this.buyConcert} className="concert-card-buy-button">
          Buy now! {this.state.price}€
        </button>
      </div>
    );
  }
}

export default ConcertCard;
