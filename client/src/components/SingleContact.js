import React from "react";

const SingleContact = ({item}) => (
    <div className="row">
        <div className="col s12 m6">
            <div className="card blue-grey darken-1">
                <div className="card-content white-text">
                    <span className="card-title">{item.firstName} {item.lastName}</span>
                    <p>Some Text h</p>
                </div>
                <div className="card-action">
                    <p>{item.email}</p>
                    <a href="#">This is a link</a>
                    <a href="#">This is a link</a>
                </div>
            </div>
        </div>
    </div>
)

export default SingleContact;