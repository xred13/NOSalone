import React, { Component } from "react";
import Concert from "./Concert";
import axios from "axios";

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

    axios.get("localhost:api")
      .then(response => {
        this.setState({
          concerts: response.data
        })
      })
      .catch(response => {
        console.log("oops, something went wrong!")

        console.log("inserting default values for concerts")
        this.setState({
          concerts: [{concertName:"First concert", name:"Dj jaime", genre:this.state.genre}, {title:"Second concert", name:"Dj mariana", genre:this.state.genre}]
        })
      })
  }

  render() {
    return (

      <div id="concerts">

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
