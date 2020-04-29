import React from "react";
import axios from "axios";
import MusicGenreElement from "./MusicGenreElement";
import "./../../../sass/homepage/music_genres/MusicGenres.scss";

const MusicGenres = props => {
  return (
    <div class="wrapper">
      <section id="section1">
        <a href="#section2">‹</a>
        <div onclick={() => props.setCurrentGenre("acoustic")} class="item">
          <img src="/images/acoustic.png" />
        </div>
        <div onclick={() => props.setCurrentGenre("chill")} class="item">
          <img src="/images/chill.png" />
        </div>
        <div onclick={() => props.setCurrentGenre("classic")} class="item">
          <img src="/images/classic.png" />
        </div>
        <div onclick={() => props.setCurrentGenre("electronic")} class="item">
          <img src="/images/electronic.png" />
        </div>
        <div onclick={() => props.setCurrentGenre("hiphop")} class="item">
          <img src="/images/hiphop.png" />
        </div>
        <a href="#section2">›</a>
      </section>
      <section id="section2">
        <a href="#section1">‹</a>
        <div onclick={() => props.setCurrentGenre("jazz")} class="item">
          <img src="/images/jazz.png" />
        </div>
        <div onclick={() => props.setCurrentGenre("pop")} class="item">
          <img src="/images/pop.png" />
        </div>
        <div onclick={() => props.setCurrentGenre("reggae")} class="item">
          <img src="/images/reggae.png" />
        </div>
        <div onclick={() => props.setCurrentGenre("rock")} class="item">
          <img src="/images/rock.png" />
        </div>
        <div onclick={() => props.setCurrentGenre("soul")} class="item">
          <img src="/images/soul.png" />
        </div>
        <a href="#section1">›</a>
      </section>
    </div>
  );
};

export default MusicGenres;
