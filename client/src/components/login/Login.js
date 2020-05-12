import React, { Component } from "react";
import axios from "axios";
import {connect} from "react-redux";
import {setLoggedInAction} from "./../../actions/loggedInActions";
import {LogIn} from "../authentication_manager/AuthenticationManager";

class Login extends Component {
  state = {
      username: "",
      password: ""
  };

  handleChange = (event) => {
    this.setState({
      [event.target.name]: event.target.value,
    });
  };

  handleSubmit = event => {

    event.preventDefault();

    LogIn(this.props.setLoggedIn, this.state.username, this.state.password);

  };

  render() {
    return (
      <div className="container">
        <div id="new-concert">
          <div className="row justify-content-center myfirst">
            <div>
              <div>
                <form onSubmit={this.handleSubmit}>

                  <div className="form-group">
                    <input 
                      placeholder="  Username"
                      type="text"
                      name="username"
                      value={this.state.username}
                      onChange={this.handleChange}
                      required
                    />
                  </div>

                  <div className="form-group">
                    <input 
                      placeholder="  Password"
                      type="text"
                      name="password"
                      value={this.state.password}
                      onChange={this.handleChange}
                      required
                    />
                  </div>

                  <input type="submit" className="btn btn-outline-secondary"></input>

                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

const mapDispatchToProps = (dispatch) => {
  return {
    setLoggedIn: (status) => dispatch(setLoggedInAction(status))
  }
}

export default connect(undefined, mapDispatchToProps)(Login);
