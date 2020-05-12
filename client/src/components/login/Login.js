import React, { Component } from "react";
import axios from "axios";

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

  handleSubmit = async (event) => {
    alert("Concert submited!");
    event.preventDefault();

    let headers = {
      "Content-Type": "application/json",
      withCredentials: true
    };

    let body = {
        name: this.state.username,
        password: this.state.password
    };

    axios.request({
      url: "http://localhost:8080/users/login",
      method: "POST",
      withCredentials: true,

      headers: {
        "Content-Type": "application/json",
      },

      data: {
        name: this.state.username,
        password: this.state.password
      }
    });

    /*
    axios.post("http://localhost:8080/users/login", body, headers)
      .then((response) => {
        console.log("Form sent successfully!");
        console.log(response);
      })
      .catch((response) => {
        console.log("oops, something went wrong!");
        console.log(response);
      }); */
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

export default Login;
