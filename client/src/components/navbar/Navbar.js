import React, { Component } from "react";
import "../../sass/navbar/Navbar.scss";
import {connect} from "react-redux";
import NavbarVisual from "./NavbarVisual";
import {setLoggedInAction} from "./../../actions/loggedInActions";

class Navbar extends Component{
  
  render(){

    return(
      <NavbarVisual isLoggedIn={this.props.isLoggedIn} setLoggedIn={this.props.setLoggedIn} />
    );

  }
}

const mapDispatchToProps = (dispatch) => {
  return{
    setLoggedIn: (status) => dispatch(setLoggedInAction(status))
  }
}

const mapStateToProps = (state) => {
  return{
    isLoggedIn: state.isLoggedIn
  }
}

export default connect(mapStateToProps, mapDispatchToProps)(Navbar);

