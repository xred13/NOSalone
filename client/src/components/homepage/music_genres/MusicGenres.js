import React from "react";
import "./../../../sass/homepage/music_genres/MusicGenres.scss";

const MusicGenres = props => {
  return (
    <div className="wrapper">
      <section id="section1">
        <a href="#section2">‹</a>
        <div onClick={() => props.setCurrentGenre("acoustic")} className="item">
          <img src="/images/acoustic.png" />
        </div>
        <div onClick={() => props.setCurrentGenre("chill")} className="item">
          <img src="/images/chill.png" />
        </div>
        <div onClick={() => props.setCurrentGenre("classic")} className="item">
          <img src="/images/classic.png" />
        </div>
        <div onClick={() => props.setCurrentGenre("electronic")} className="item">
          <img src="/images/electronic.png" />
        </div>
        <div onClick={() => props.setCurrentGenre("hiphop")} className="item">
          <img src="/images/hiphop.png" />
        </div>
        <a href="#section2">›</a>
      </section>
      <section id="section2">
        <a href="#section1">‹</a>
        <div onClick={() => props.setCurrentGenre("jazz")} className="item">
          <img src="/images/jazz.png" />
        </div>
        <div onClick={() => props.setCurrentGenre("pop")} className="item">
          <img src="/images/pop.png" />
        </div>
        <div onClick={() => props.setCurrentGenre("reggae")} className="item">
          <img src="/images/reggae.png" />
        </div>
        <div onClick={() => props.setCurrentGenre("rock")} className="item">
          <img src="/images/rock.png" />
        </div>
        <div onClick={() => props.setCurrentGenre("soul")} className="item">
          <img src="/images/soul.png" />
        </div>
        <a href="#section1">›</a>
      </section>
    </div>
  );
};

export default MusicGenres;
