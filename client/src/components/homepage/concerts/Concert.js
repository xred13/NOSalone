import React, { Component } from "react";

const Concert = (props) => {
  const { artistName, date, numberMaxFans, imgBase64 } = props.concertData;

  return (
    <div>
      <hr />
      {artistName}
      <br />
      {date}
      <br />
      {numberMaxFans}
      <br />
      <img src={imgBase64} />
      <hr />
    </div>
  );
};

export default Concert;
