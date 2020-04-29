import React, { Component } from "react";
import "../../sass/banner/banner.scss";

class Banner extends Component {
  render() {
    return (
      <div className="row">
        <div className="col-md-12 banner">
          <img
            id="banner-img"
            src="https://i.picsum.photos/id/411/2000/400.jpg"
          ></img>
        </div>
      </div>
    );
  }
}
export default Banner;
