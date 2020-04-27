import React, { Component } from "react";
import "../../sass/navbar/Navbar.scss";

class Navbar extends Component {
  render() {
    return (
        <div id="navbar">

            <button className="navbar-button">Homepage</button>
            <button className="navbar-button">button8</button>
            <button className="navbar-button">button2</button>

        </div>
    );
  }
}

export default Navbar;
