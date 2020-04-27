import React, { Component } from 'react';
import axios from "axios";
import ImageUploader from "react-images-upload";

class NewConcert extends Component {
    state = { 
        concertName: "",
        artistName: "",
        date: "",
        slots: null,
        image: null
     }

     handleChange = (event) => {
        this.setState({
            [event.target.name]: event.target.value
        })
     }

     handleImageChange = (image) => {
         this.setState({
             image: image[0]
         })
     }

     getBase64 = file => {
        return new Promise(resolve => {
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
         alert("Concert submited!")
         event.preventDefault();

         let formData = new FormData();

         let imageBase64 = null;
         this.getBase64(this.state.image)
            .then(result => {
                imageBase64 = result;
            })

         formData.append("concertName", this.state.concertName)
         formData.append("artistName", this.state.artistName)
         formData.append("date", this.state.date)
         formData.append("slots", this.state.slots)
         formData.append("image", imageBase64)

         const config = {
             headers: {
                 "content-type": "multipart/form-data"
             }
         }

         axios.post("localhost:api/something", formData, config)
            .then(response => {
                console.log("Form sent successfully!")
                console.log(response)
            })
            .catch(response => {
                console.log("oops, something went wrong!")
                console.log(response)
            })

     }

    render() { 
        return ( 
            <div id="new-concert">
                <form onSubmit={this.handleSubmit}>
                    <label>
                        Concert Name:
                        <input type="text" name="concertName" value={this.state.concertName} onChange={this.handleChange}/>
                    </label>
                    <br/>
                    <label>
                        Artist Name:
                        <input type="text" name="artistName" value={this.state.artistName} onChange={this.handleChange}/>
                    </label>
                    <br/>
                    <label>
                        Date:
                        <input type="text" name="date" value={this.state.date} onChange={this.handleChange}/>
                    </label>
                    <br/>
                    <label>
                        Slots:
                        <input type="number" name="slots" value={this.state.slots} onChange={this.handleChange}/>
                    </label>
                    <br/>
                    <label>
                        Image:
                        <ImageUploader
                            withIcon={true}
                            buttonText="Choose image"
                            onChange={this.handleImageChange}
                            imgExtension={[".jpg", ".gif", ".png"]}
                            maxFileSize={5242880}
                            singleImage={true}
                        />
                    </label>
                    <br/>
                    <input type="submit" value="Submit"/>
                </form>
            </div>
         );
    }
}
 
export default NewConcert;