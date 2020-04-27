import React, { Component } from "react";

const Concert = (props) => {
  const { concertName, artistName, date, slots, image } = props.concertData;

  return (
    <div>
      <hr />
      {concertName}
      <br />
      {artistName}
      <br />
      {date}
      <br />
      {slots}
      <br />
      {image}
      <hr />
    </div>
  );
};

export default Concert;
