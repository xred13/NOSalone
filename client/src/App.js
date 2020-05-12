import React from "react";
import HomePage from "./components/homepage/HomePage";
import { Route, BrowserRouter, Switch } from "react-router-dom";
import Default404 from "./components/default404/Default404";
import Banner from "./components/banner/Banner";
import "./sass/root/Root.scss";
import NewConcert from "./components/concert_form/NewConcert";
import Login from "./components/login/Login";
import Test from "./components/navbar/NavbarVisual";
import Navbar from "./components/navbar/Navbar";

function App() {
  return (
    <BrowserRouter>

      <Navbar />
      <Banner />

      <Switch>

        <Route exact path="/" component={HomePage} />

        <Route path="/form" component={NewConcert} />
        <Route path="/login" component={Login} />

        <Route component={Default404} />

      </Switch>
    </BrowserRouter>
  );
}

export default App;
