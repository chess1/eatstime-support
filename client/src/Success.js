import React, { Component } from "react";
import "./App.css";

class Success extends Component {

    render() {

        return (
            <div>
                <div className="flex flex-column success">
                    <div className="golf-slogan-image mx-auto"></div>
                    <div className="flex flex-column mt3">
                        <p className="m0 bold-600 success-text">Your feedback</p>
                        <p className="m0 mt3">has beed sent successfully</p>
                    </div>

                    <div className="success-image mt2"></div>
                </div>
                <div className="ampersand-image mx-auto"></div>
            </div>

        );
    }
}


export default Success;
