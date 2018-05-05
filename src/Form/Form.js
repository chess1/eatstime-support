import React, { Component } from "react";
import "../App.css";
import { ValidatorForm } from "react-form-validator-core";
import { TextValidator } from "react-material-ui-form-validator";
//import axios from "axios";


class FormContainer extends Component {

    state = {
        hasError: false,
        form: {
            email: '',
            firstName: '',
            lastName: '',
            feedback: ''
        },
        //termsApproved: false,

    };

    handleChange(prop, e) {
        const val = e.target.value;
        const newForm = {
            ...this.state.form,
            [prop]: val
        };
        this.setState({ form: newForm });
    }

    componentWillMount() {
        ValidatorForm.addValidationRule('isTruthy', value => !!value);
        ValidatorForm.addValidationRule('isEnglishOrHebrew', value => !/[a-z][^\u0590-\u05fe]*[\u0590-\u05fe]|[\u0590-\u05fe][^a-z]*[a-z]/i.test(value) && /[a-zA-Z\u0590-\u05fe]/.test(value));
        ValidatorForm.addValidationRule('isValidEmail', value => /^[a-zA-Z0-9]+(?:\.[a-zA-Z0-9]+)*@(?:[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?\.)+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?$/.test(value));
    }

    _onSubmit() {
        const { changeStep } = this.props;

        const data = {
            email: this.state.form.email,
            firstName: this.state.form.firstName,
            lastName: this.state.form.lastName,
            feedback: this.state.form.feedback,
            //termsApproved: this.state.termsApproved,
        };


        setTimeout(() => {
            changeStep();
            console.log(data);
        }, 2000)

    }

    render() {
        //const { termsApproved } = this.state;


        return (
            <ValidatorForm className="mui-form form-container" ref="form"
                           onSubmit={() => this._onSubmit()}
                           name="signup-form"
                           onError={errors => console.log(errors)}>
                <div className="logo"/>
                <TextValidator
                    floatingLabelText="Firstname "
                    fullWidth={true}
                    name="firstname"
                    onChange={(e) => this.handleChange("firstName", e)}
                    floatingLabelStyle={floatingLabelStyle}
                    value={this.state.form.firstName}
                    errorStyle={errorStyle}
                    underlineStyle={underlineStyle}
                    underlineFocusStyle={disableUnderlineTransition}
                    validators={['required']}
                    errorMessages={['This field is required !']}
                />
                <TextValidator
                    floatingLabelText="Lastname"
                    fullWidth={true}
                    name="lastname"
                    value={this.state.form.lastName}
                    onChange={(e) => this.handleChange("lastName", e)}
                    floatingLabelStyle={floatingLabelStyle}
                    underlineStyle={underlineStyle}
                    underlineFocusStyle={disableUnderlineTransition}
                    errorStyle={errorStyle}
                    validators={['required']}
                    errorMessages={['This field is required !']}
                />
                <TextValidator
                    floatingLabelText="Email"
                    fullWidth={true}
                    type="mail"
                    errorStyle={errorStyle}
                    onChange={(e) => this.handleChange("email", e)}
                    name="email"
                    value={this.state.form.email}
                    floatingLabelStyle={floatingLabelStyle}
                    underlineStyle={underlineStyle}
                    underlineFocusStyle={disableUnderlineTransition}
                    validators={['required', 'isValidEmail', 'isEmail']}
                    errorMessages={['This field is required !', 'Email is invalid', 'Email is invalid']}
                />

                <TextValidator
                    onChange={(e) => this.handleChange("feedback", e)}
                    validators={['required']}
                    errorStyle={errorStyle}
                    floatingLabelText="Write your feedback . . ."
                    fullWidth={true}
                    floatingLabelStyle={floatingLabelStyle}
                    underlineStyle={underlineStyle}
                    underlineFocusStyle={disableUnderlineTransition}
                    type="text"
                    errorMessages={['This field is required !']}
                    name="feedback"
                    value={this.state.form.feedback}
                    multiLine={true}
                    rows={5}
                    inputStyle={{ textAlign: 'left', direction: 'ltr' }}
                />
                {/*<div className="mt4">*/}
                {/*<ToggleValidatorElement*/}
                {/*onChange={() => this.setState({ termsApproved: !this.state.termsApproved })}*/}
                {/*validators={['isTruthy']}*/}
                {/*name="toggle"*/}
                {/*errorMessages={['שדה זה חובה!']}*/}
                {/*value={termsApproved}/>*/}
                {/*</div>*/}

                <button className="submit-button mx-auto mt3" type="submit">Send</button>

            </ValidatorForm>
        );
    }
}

const errorStyle = {
    textAlign: "right",
};

const floatingLabelStyle = {
    color: "#454545",
    fontSize: "13px"
};

const underlineStyle = {
    borderBottom: "1px solid #454545"
};

const disableUnderlineTransition = {
    transition: "none"
};


export default FormContainer;


