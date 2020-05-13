import React, { Component } from "react";
import {CreateAccount} from "./../authentication_manager/AuthenticationManager";

class Register extends Component {
  state = {
      username: "",
      email: "",
      password: ""
  };

  handleChange = (event) => {
    this.setState({
      [event.target.name]: event.target.value,
    });
  };

  handleSubmit = (event) => {
      event.preventDefault();
    CreateAccount( this.state.username, this.state.email, this.state.password);
        
  };

  render() {
    return (
      <div className="container">
        <div id="new-concert">
          <div className="row justify-content-center myfirst">
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
                  placeholder="  Email"
                  type="email"
                  name="email"
                  value={this.state.email}
                  onChange={this.handleChange}
                  required
                />
              </div>

              <div className="form-group">
                <input
                  placeholder="  Password"
                  type="password"
                  name="password"
                  value={this.state.password}
                  onChange={this.handleChange}
                  required
                />
              </div>

              <input
                type="submit"
                className="btn btn-outline-secondary"
              ></input>
            </form>
          </div>
        </div>
      </div>
    );
  }
}

export default Register;
