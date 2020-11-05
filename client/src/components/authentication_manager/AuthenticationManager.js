import axios from "axios";

export function LogIn(dispatch, username, password) {

  axios
    .request({
      url: "http://localhost:8080/users/login",
      method: "POST",
      withCredentials: true,

      headers: {
        "Content-Type": "application/json",
      },

      data: {
        name: username,
        password: password
      },
    })
    .then((response) => {
      console.log(response);

      if (response.data) {
        alert("Successfully logged in!");
        localStorage.setItem("isLoggedIn", true);
        localStorage.setItem("loggedInDateTime", new Date());
        dispatch(true);
      } else {
        alert("Please enter the correct username and password!");
      }
    })
    .catch((response) => {
      alert("Oops, something went wrong!");
    });
}

export function LogOut(dispatch) {
  console.log("Setting localstorage and redux status to logged out!");

  axios
    .request({
      url: "http://localhost:8080/users/logout",
      method: "GET",
      withCredentials: true,
    }).then((response) => {
      alert("Successfully logged out!");
      localStorage.setItem("isLoggedIn", false);
      localStorage.setItem("loggedInDateTime", null);
      dispatch(false);
    }).catch((response) => {
      alert("Oops, something went wrong!");
    });
}

export function CheckLoggedIn() {
  console.log("Checking if we are logged in!");
  console.log("TEST:" + localStorage.getItem("isLoggedIn"));
  if (localStorage.getItem("isLoggedIn") === "true") {
    if (HasExpired(localStorage.getItem("loggedInDateTime"))) {
      console.log("We were logged in but it expired!");
      localStorage.setItem("isLoggedIn", false);
      localStorage.setItem("loggedInDateTime", null);
      return { isLoggedIn: false };
    } else {
      console.log("We are already logged in!");
      localStorage.setItem("isLoggedIn", true);
      localStorage.setItem("loggedInDateTime", new Date());
      return { isLoggedIn: true };
    }
  } else {
    console.log("isLoggedIn is either false or hasnt been added yet!");
    // isLoggedIn is either false or hasn't yet been added to localstorage
    localStorage.setItem("isLoggedIn", false);
    localStorage.setItem("loggedInDateTime", null);
    return { isLoggedIn: false };
  }
}

export function CreateAccount(username, email, password) {
  axios
    .request({
      url: "http://localhost:8080/users/register",
      method: "POST",

      headers: {
        "Content-Type": "application/json",
      },

      data: {
        name: username,
        email: email,
        password: password,
      },
    })
    .then((response) => {
      alert("You have successfully registered!");
    })
    .catch((response) => {
      alert("Oops, something went wrong with your registration!");
    });
}

function HasExpired(dateTime) {
  var currentDateTime = new Date();

  var expirationDate = currentDateTime;
  expirationDate.setMonth(currentDateTime.getMonth + 3);

  return dateTime > expirationDate;
}
