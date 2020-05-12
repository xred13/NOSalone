import React, { Component } from "react";
import { makeStyles } from "@material-ui/core/styles";
import AppBar from "@material-ui/core/AppBar";
import Toolbar from "@material-ui/core/Toolbar";
import Typography from "@material-ui/core/Typography";
import Button from "@material-ui/core/Button";
import IconButton from "@material-ui/core/IconButton";
import MenuIcon from "@material-ui/icons/Menu";
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

