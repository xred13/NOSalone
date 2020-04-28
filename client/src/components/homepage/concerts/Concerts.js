import React, { Component } from "react";
import Concert from "./Concert";
import axios from "axios";
import NewConcert from "./NewConcert";

class Concerts extends Component {

  state = {
    genre: null,
    concerts: []
  };
  
  componentWillReceiveProps(nextProps){

    console.log("Received props")
    console.log(nextProps)

    this.setState({
      genre: nextProps.currentGenre
    })

    axios.get("http://localhost:8080/NosAlone/concert/concerts")
      .then(response => {
        this.setState({
          concerts: response.data
        })
      })
      .catch(response => {
        console.log("oops, something went wrong!")

        console.log("inserting default values for concerts")
        this.setState({
          concerts: [{concertName:"First concert", artistName:"Dj jaime", date:"25/1/9999", slots:6, image:"something goes here:)"}, {concertName:"second greatest concert", artistName:"Dj marina", date:"25/1/0000", slots:1, image:"something goes here"}]
        })
      })
  }

  render() {
    return (

      <div id="concerts">

        <NewConcert/>

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
