import React from "react";
import HomePage from "./components/homepage/HomePage";
import { Route, BrowserRouter, Switch, HashRouter } from "react-router-dom";
import Default404 from "./components/default404/Default404";
import Banner from "./components/banner/Banner";
import "./sass/root/Root.scss";
import NewConcert from "./components/concert_form/NewConcert";
import Login from "./components/login/Login";
import Navbar from "./components/navbar/Navbar";
import MyProfile from "./components/my_profile/MyProfile";
import Register from "./components/register/Register";

function App() {
  return (
    <BrowserRouter basename={process.env.PUBLIC_URL}>

      <Navbar />
      <Banner />

      <Switch>

        <Route exact path="/" component={HomePage} />
        <Route path="/form" component={NewConcert} />
        <Route path="/login" component={Login} />
        <Route path="/register" component={Register} />
        <Route path="/myprofile" component={MyProfile} />

        <Route component={Default404} />

      </Switch>
    </BrowserRouter>
  );
}

export default App;
