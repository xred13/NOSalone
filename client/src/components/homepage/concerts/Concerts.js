import React, { Component } from "react";
import Concert from "./Concert";
import axios from "axios";
import NewConcert from "./NewConcert";

class Concerts extends Component {

  state = {
    genre: null,
    concerts: []
  };
  
  componentWillReceiveProps = (nextProps) => {

    if(nextProps.currentGenre === null){
      return;
    }

    this.setState({
      genre: nextProps.currentGenre
    })

    let params = {
      musicGenre: nextProps.currentGenre
    }

    axios.get("http://localhost:8080/NosAlone/concert/concerts", {params})
      .then(response => {
        this.setState({
          concerts: response.data
        })
      })
      .catch(response => {
        console.log("oops, something went wrong!")
        console.log(response)

        console.log("inserting default values for concerts")
        this.setState({
          concerts: [{artistName:"Dj jaime", date:"25/1/9999", numberMaxFans:6, imgBase64:"something goes here:)"}, {artistName:"Dj marina", date:"25/1/0000", numberMaxFans:1, imgBase64:"something goes here"}]
        })
      })
  }

  render() {
    return (

      <div id="concerts">

        <NewConcert genre={this.state.genre}/>

        {this.state.genre != null ? 

          this.state.concerts.map((concertData, i) => (
            <Concert concertData={concertData} key={i}/>
          ))

          :

          <div>
            Sorry, no concerts for this given genre!
          </div>

        }

      </div>
    );
  }
}

export default Concerts;
