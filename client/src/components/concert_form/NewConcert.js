import React, { Component } from "react";
import axios from "axios";
import ImageUploader from "react-images-upload";
import "../../sass/concert_form/NewConcert.scss";

class NewConcert extends Component {
  state = {
    concertName: "",
    musicGenre: "",
    performanceDate: "",
    image: null,
    price: 50,
    description: "",
    slots: 0
  };

  handleChange = (event) => {
    this.setState({
      [event.target.name]: event.target.value,
    });
  };

  handleImageChange = (image) => {
    this.setState({
      image: image[0],
    });
  };

  getBase64 = (file) => {
    return new Promise((resolve) => {
      let baseURL = "";
      // Make new FileReader
      let reader = new FileReader();

      // Convert the file to base64 text
      reader.readAsDataURL(file);

      // on reader load somthing...
      reader.onload = () => {
        // Make a fileInfo Object
        console.log("Called", reader);
        baseURL = reader.result;
        resolve(baseURL);
      };
    });
  };

  handleSubmit = async (event) => {
    alert("Concert submited!");
    event.preventDefault();

    let imageBase64 = null;
    await this.getBase64(this.state.image).then((result) => {
      imageBase64 = result;
    });

    axios.request({
      url: "http://localhost:8080/concerts/create",
      method: "POST",
      withCredentials: true,

      headers:{
        "Content-Type": "application/json",
      },

      data:{
        "performanceDate": this.state.performanceDate,
        "slots": this.state.slots,
        "concertName": this.state.concertName,
        "musicGenre": this.state.musicGenre,
        "price": this.state.price,
        "imgBase64": imageBase64,
        "description": this.state.description
      }

    }).then((response) => {
        console.log("Form sent successfully!");
        console.log(response);
      })
      .catch((response) => {
        console.log("oops, something went wrong!");
        console.log(response);
      });
  };

  render() {
    return (
      <div className="container">
        <div id="new-concert">
          <div className="row justify-content-center myfirst">
            <div>
              <div>
                <form onSubmit={this.handleSubmit}>

                  <div className="form-group">
                    <input className="ConcertName"
                      placeholder="  Concert Name"
                      type="text"
                      name="concertName"
                      value={this.state.concertName}
                      onChange={this.handleChange}
                      required
                    />
                  </div>

                  <div className="form-group">
                    <select 
                      id="inputState" 
                      class="form-control" 
                      name="musicGenre" 
                      value={this.state.musicGenre} 
                      onChange={this.handleChange}
                      required
                    >
                      <option selected value=""> Choose Music Genre</option>
                      <option value="acoustic">Acoustic</option>
                      <option value="chill">Chill</option>
                      <option value="classic">Classic</option>
                      <option value="electronic">Eletronic</option>
                      <option value="hiphop">HipHop</option>
                      <option value="jazz">Jazz</option>
                      <option value="pop">Pop</option>
                      <option value="reggae">Reggae</option>
                      <option value="rock">Rock</option>
                      <option value="soul">Soul</option>
                    </select>
                  </div>

                  <div className="form-group">
                    <textarea 
                      placeholder="Concert Description" 
                      className="form-control" 
                      id="exampleFormControlTextarea1" 
                      rows="3"
                      name="description"
                      value={this.state.description}
                      onChange={this.handleChange}
                      required
                    >
                    </textarea>
                  </div>

                  <div className="d-flex justify-content-center my-4 pt-3">
                    <span className="font-weight-bold indigo-text mr-2 mt-1"><i className="fas fa-dollar-sign" aria-hidden="true"></i>0€</span>
                    <div id="price"> 
                      {this.state.price}€
                    </div>
                    <form className="range-field w-75" >
                      <input className="border-0" id="price-slider" 
                      name="price"
                      type="range" 
                      min="0" max="100" 
                      value={this.state.price} 
                      onChange={this.handleChange} />
                    </form>
                    <span class="font-weight-bold indigo-text ml-2 mt-1"><i className="fas fa-euro-sign" aria-hidden="true"> 100€</i></span>
                  </div>

                  <div className="form-group">
                    <input className="slots"
                      type="number"
                      name="slots"
                      value={this.state.slots}
                      onChange={this.handleChange}
                      required
                    />
                  </div>

                  <div className="form-group">
                    <div className="date">
                      <label for="exampleFormControlSelect1"></label>
                      <input
                        className="Date"
                        type="datetime-local"
                        name="performanceDate"
                        value={this.state.performanceDate}
                        onChange={this.handleChange}
                        required
                      />
                    </div>
                  </div>

                  <br />
                  <label id="upload">
                    <ImageUploader
                      withIcon={true}
                      buttonText="Upload Image"
                      onChange={this.handleImageChange}
                      imgExtension={[".jpg", ".gif", ".png"]}
                      maxFileSize={5242880}
                      singleImage={true}
                    />
                  </label>
                  <br />
                  <input type="submit" class="btn btn-outline-secondary"></input>

                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default NewConcert;
