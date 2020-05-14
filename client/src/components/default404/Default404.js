import React, { Component } from "react";
import "./../../sass/pageNotFound.scss";

class Default404 extends Component {
  render() {
    return (
      <div>
        <div id="container">
          <div className="content">
            <h2>404</h2>
            <h4>Oops! Page not found</h4>
            <h3>But here’s a treat!</h3>
            <div className="col-md-12 movie">
              <iframe
                width="560"
                height="315"
                src="https://www.youtube.com/embed/t99KH0TR-J4"
                frameborder="0"
                allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
                allowfullscreen
                title="The show must go on - Queen"
              ></iframe>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default Default404;
