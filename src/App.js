import React from "react";
import HomePage from "./components/homepage/HomePage";
import { BrowserRouter, Route } from "react-router-dom";
import Default404 from "./components/default404/Default404";
import Navbar from "./components/navbar/Navbar";
import Banner from "./components/banner/Banner";
import "./sass/root/Root.scss";
import NewConcert from './components/concert_form/NewConcert';

function App() {
  return (
    <BrowserRouter>
      <Navbar />

      <Banner />

      <Route exact path="/" component={HomePage} />

      <Route exact path="/form" component={NewConcert} />
      <Route exact path="/....." component={Default404} />
    </BrowserRouter>
  );
}

export default App;
