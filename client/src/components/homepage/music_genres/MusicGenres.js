import React from "react";
import axios from "axios";
import MusicGenreElement from "./MusicGenreElement";
import "./../../../sass/homepage/music_genres/MusicGenres.scss";

const MusicGenres = props => {
  return (
    /*
    {props.genres.map((genre, i) => (
      <MusicGenreElement

        setCurrentGenre={props.setCurrentGenre}
        genre={genre}
        key={i}
      />
    ))}*/

    <div className="wrapper">
      <section id="section1">
        <a href="#section3">‹</a>
        <div className="item">
          <img src="https://i.picsum.photos/id/316/200/200.jpg" />
        </div>
        <div className="item">
          <img src="https://i.picsum.photos/id/36/200/200.jpg" />
        </div>
        <div className="item">
          <img src="https://i.picsum.photos/id/31/200/200.jpg" />
        </div>
        <div className="item">
          <img src="https://i.picsum.photos/id/16/200/200.jpg" />
        </div>
        <div className="item">
          <img src="https://i.picsum.photos/id/39/200/200.jpg" />
        </div>
        <a href="#section3">›</a>
      </section>
      <section id="section2">
        <a href="#section1">‹</a>
        <div className="item">
          <img src="https://i.picsum.photos/id/416/200/200.jpg" />
        </div>
        <div className="item">
          <img src="https://i.picsum.photos/id/397/200/200.jpg" />
        </div>
        <div className="item">
          <img src="https://i.picsum.photos/id/216/200/200.jpg" />
        </div>
        <div className="item">
          <img src="https://i.picsum.photos/id/916/200/200.jpg" />
        </div>
        <div className="item">
          <img src="https://i.picsum.photos/id/318/200/200.jpg" />
        </div>
        <a href="#section3">›</a>
      </section>

      <section id="section3">
        <a href="#section2">‹</a>
        <div className="item">
          <img src="https://i.picsum.photos/id/300/200/200.jpg" />
        </div>
        <div className="item">
          <img src="https://i.picsum.photos/id/309/200/200.jpg" />
        </div>
        <div className="item">
          <img src="https://i.picsum.photos/id/123/200/200.jpg" />
        </div>
        <div className="item">
          <img src="https://i.picsum.photos/id/458/200/200.jpg" />
        </div>
        <div className="item">
          <img src="https://i.picsum.photos/id/90/200/200.jpg" />
        </div>
        <a href="#section1">›</a>
      </section>
    </div>
  );
};

export default MusicGenres;
