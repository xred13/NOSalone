import React, { Component } from "react";

import { makeStyles } from "@material-ui/core/styles";
import clsx from "clsx";
import Card from "@material-ui/core/Card";
import CardHeader from "@material-ui/core/CardHeader";
import CardMedia from "@material-ui/core/CardMedia";
import CardContent from "@material-ui/core/CardContent";
import CardActions from "@material-ui/core/CardActions";
import Collapse from "@material-ui/core/Collapse";
import Avatar from "@material-ui/core/Avatar";
import IconButton from "@material-ui/core/IconButton";
import Typography from "@material-ui/core/Typography";
import { red } from "@material-ui/core/colors";
import FavoriteIcon from "@material-ui/icons/Favorite";
import ShareIcon from "@material-ui/icons/Share";
import ExpandMoreIcon from "@material-ui/icons/ExpandMore";
import MoreVertIcon from "@material-ui/icons/MoreVert";
import "./../../../sass/homepage/concerts/Concerts.scss";

import axios from "axios";

const Concert = props => {
  const {
    artistName,
    concertName,
    description,
    date,
    price,
    imgBase64
  } = props.concertData;

  const useStyles = makeStyles(theme => ({
    root: {
      maxWidth: 345
    },
    media: {
      height: 0,
      paddingTop: "56.25%" // 16:9
    },
    expand: {
      transform: "rotate(0deg)",
      marginLeft: "auto",
      transition: theme.transitions.create("transform", {
        duration: theme.transitions.duration.shortest
      })
    },
    expandOpen: {
      transform: "rotate(180deg)"
    },
    avatar: {
      backgroundColor: red[500]
    }
  }));

  const classes = useStyles();
  const [expanded, setExpanded] = React.useState(false);

  const handleExpandClick = () => {
    setExpanded(!expanded);
  };

  const buyConcert = () => {

    alert("You will soon be contacted with information regarding your private concert!")

    let params = {
        "date": date,
        "artistName": artistName,
        "concertName": concertName,
    }

    axios.get("http://localhost:8080/api/concerts/buy", {params})
      .then(response => {
        console.log("bought concert! :)")
      })
      .catch(response => {
        console.log("oops, something went wrong!")
        console.log(response)
      })

    props.removeConcert(props.index);

  }

  return (
    <Card className={classes.root} id="concert">
      <CardHeader
        avatar={
          <Avatar aria-label="recipe" className={classes.avatar}>
            <img src="https://i.picsum.photos/id/1072/40/40.jpg" />
          </Avatar>
        }
        action={
          <IconButton aria-label="settings">
            <MoreVertIcon />
          </IconButton>
        }
        title={artistName}
        subheader={date}
      />
      <CardMedia
        className={classes.media}
        image={imgBase64}
        title="Paella dish"
      />
      <CardContent>
        <Typography variant="body2" color="textSecondary" component="p">
          Concert name: {concertName}
        </Typography>
      </CardContent>
      <CardActions disableSpacing>
        <IconButton aria-label="add to favorites">
          <FavoriteIcon />
        </IconButton>
        <IconButton aria-label="share">
          <ShareIcon />
        </IconButton>
        <button
          variant="outlined"
          onClick={buyConcert}
          className="btn buy-btn"
          data-toggle="modal"
          data-target="#exampleModal"
        >
          BUY NOW {price}€
        </button>
        <IconButton
          className={clsx(classes.expand, {
            [classes.expandOpen]: expanded
          })}
          onClick={handleExpandClick}
          aria-expanded={expanded}
          aria-label="show more"
        >
          <ExpandMoreIcon />
        </IconButton>
      </CardActions>
      <Collapse in={expanded} timeout="auto" unmountOnExit>
        <CardContent>
          <Typography paragraph>{description}</Typography>
        </CardContent>
      </Collapse>
    </Card>
  );
};

export default Concert;
