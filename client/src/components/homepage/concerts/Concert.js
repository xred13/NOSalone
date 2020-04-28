import React, { Component } from "react";

const Concert = (props) => {

  return (
    <div>
        {props.concertData.title}
        {props.concertData.name}
        {props.concertData.genre}
    </div>
  );
};

export default Concert;
