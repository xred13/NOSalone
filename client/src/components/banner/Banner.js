import React, { Component } from "react";
import "../../sass/banner/banner.scss";

class Banner extends Component {
  render() {
    return (
      <div className="row">
        <div className="col-md-12 banner">
          <img id="banner-img" src="/images/bannerHome.png" alt="NOSalone"></img>
        </div>
      </div>
    );
  }
}
export default Banner;
