import React, { Component } from "react";
import Header from "./Header/Header";
import "./App.css";
import FormContainer from "./Form/Form";
import Success from "./Success";
import { Grid, Row, Col } from "react-bootstrap";

const STEP = {
    REGISTER: "register",
    AUTH: "auth",
    SUCCESS: "success"
};

class App extends Component {

    state = {
        step: STEP.REGISTER,
        customer: {},
    };

    render() {
        const { step } = this.state;

        return (
            <Grid className="App">
                <Row>
                    <Col xs={12} sm={8} md={8} lg={8} xl={8} xsOffset={2} smOffset={2} mdOffset={2} lgOffset={2}
                         xlOffset={2}>
                        <Header/>
                    </Col>
                </Row>
                <Row>
                    <Col xs={12} sm={8} md={8} lg={8} xl={8} xsOffset={2} smOffset={2} mdOffset={2} lgOffset={2}
                         xlOffset={2}>
                        {
                            (step === STEP.REGISTER ?
                             <FormContainer changeStep={() => this.setState({ step: STEP.SUCCESS })}/> :
                             <Success/>)
                        }
                    </Col>
                </Row>

            </Grid>
        );
    }
}

export default App;
