import React, {Component} from "react";
import ConcertsBought from "./concerts_bought/ConcertsBought";
import MyConcerts from "./my_concerts/MyConcerts";
import "../../sass/my_profile/MyProfile.scss";

class MyProfile extends Component {
    state = { 
        currentCategory: "Concerts Bought"
     }

     updateCurrentCategory = (category) => {
         this.setState({
             currentCategory: category
         })
     }

    render() { 
        return ( 
            <div id="myprofile">

                <MyConcerts />
                <ConcertsBought/>

            </div>
         );
    }
}
 
export default MyProfile;