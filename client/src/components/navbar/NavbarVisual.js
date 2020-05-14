import React from "react";
import { makeStyles } from "@material-ui/core/styles";
import AppBar from "@material-ui/core/AppBar";
import Toolbar from "@material-ui/core/Toolbar";
import Typography from "@material-ui/core/Typography";
import Button from "@material-ui/core/Button";
import "../../sass/navbar/Navbar.scss";
import { LogOut } from "./../authentication_manager/AuthenticationManager";

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

export default function ButtonAppBar(props) {
  const classes = useStyles();

  return (
    <div className={classes.root} id="navbar">
      <AppBar position="static">
        <Toolbar>
          <Typography variant="h6" className={classes.title}>
            <a className="navbar-text" href="/">
              NOS alone'20
            </a>
          </Typography>
          {props.isLoggedIn ? (
            <React.Fragment>
              <Button href="/form">
                <div className="navbar-text">Add a concert</div>
              </Button>
              <Button href="/myprofile">
                <div className="navbar-text">MyProfile</div>
              </Button>
              <Button onClick={() => LogOut(props.setLoggedIn)}>
                <div className="navbar-text">Logout</div>
              </Button>
            </React.Fragment>
          ) : (
            <React.Fragment>
              <Button href="/login">
                <div className="navbar-text">Login</div>
              </Button>
              <Button href="/register">
                <div className="navbar-text">Register</div>
              </Button>
            </React.Fragment>
          )}
        </Toolbar>
      </AppBar>
    </div>
  );
}
