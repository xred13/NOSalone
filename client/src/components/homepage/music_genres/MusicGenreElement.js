import React from "react";
import { makeStyles } from "@material-ui/core/styles";
import Card from "@material-ui/core/Card";
import CardActions from "@material-ui/core/CardActions";
import CardContent from "@material-ui/core/CardContent";
import Button from "@material-ui/core/Button";
import Typography from "@material-ui/core/Typography";

const MusicGenreElement = props => {
  const useStyles = makeStyles({
    root: {
      minWidth: 275
    },
    bullet: {
      display: "inline-block",
      margin: "0 2px",
      transform: "scale(0.8)"
    },
    title: {
      fontSize: 14
    },
    pos: {
      marginBottom: 12
    }
  });

  const classes = useStyles();

  return (
    <div onClick={() => props.setCurrentGenre(props.genre)}>
      <Card className={classes.root}>
        <CardContent>
          <Typography variant="h5" component="h2">
            {props.genre}
          </Typography>
        </CardContent>
      </Card>
    </div>
  );
};

export default MusicGenreElement;
/*
<div
onClick={() => props.setCurrentGenre(props.genre)}
  className="music-genre-element"
>
  {props.genre}
</div>
*/
