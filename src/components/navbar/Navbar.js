import React, { Component } from "react";
import { makeStyles } from "@material-ui/core/styles";
import AppBar from "@material-ui/core/AppBar";
import Toolbar from "@material-ui/core/Toolbar";
import Typography from "@material-ui/core/Typography";
import Button from "@material-ui/core/Button";
import IconButton from "@material-ui/core/IconButton";
import MenuIcon from "@material-ui/icons/Menu";
import "../../sass/navbar/Navbar.scss";

const useStyles = makeStyles((theme) => ({
  root: {
    flexGrow: 1,
  },
  menuButton: {
    marginRight: theme.spacing(2),
  },
  title: {
    flexGrow: 1,
  },
}));

const dosomething = () => {
  console.log("CLICKED :)");
};

export default function ButtonAppBar() {
  const classes = useStyles();

  return (
    <div className={classes.root} id="navbar">
      <AppBar position="static">
        <Toolbar>
          <Typography variant="h6" className={classes.title}>
            <a className="navbar-text" href="/">NOS alone'20</a>
          </Typography>
          <Button href="/form">
            <div className="navbar-text">
              Add a concert
            </div>
          </Button>
          <Button href="/login">
            <div className="navbar-text">
              Login
            </div>
          </Button>
        </Toolbar>
      </AppBar>
    </div>
  );
}
