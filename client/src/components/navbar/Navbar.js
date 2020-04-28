import React, { Component } from "react";
import "../../sass/navbar/Navbar.scss";


class Navbar extends Component {
  render() {
    return (
      <div className="con">
        <div className="row">
          <div id="navbar" className="col-md-12">
            <nav className="nav-item col-12-md navebar navbar-light bg-light">
              <a href="404.html" className="navbar-brand">NosALONE</a>
              <ul className="navbar-nav mr-auto">
                <li className="nav-item">
                  <a href="#" className="nav-link">I'm an Artist</a>
                </li>

              </ul>
            </nav>
          </div>
        </div>


        <div className="row justify-content-center">
            <img id="nosAlone" src="https://i.picsum.photos/id/411/1600/800.jpg" className="img-fluid" ></img>
        </div>

      </div>
    );
  }
}

export default Navbar;
