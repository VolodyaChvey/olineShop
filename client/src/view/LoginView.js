import React from "react";
import { Button } from "react-bootstrap";
import Label from "../components/Label";

export default class LoginView extends React.Component{
    constructor(props){
        super(props);
        this.state = {};
    }

    render(){
        return(
            <div className="container">
                <br></br>
                <div className="row">
                    <div className="col-3"></div>
                    <div className="col-6">
                        <Label text={"Login to the Online Shop"}></Label>
                    </div>
                    <div className="col-3"></div>
                </div>

                <div className="row">
                    <div className="col-5"></div>
                    <div className="col-4">
                        <p className="color-red">
                             {this.props.loginRequired &&
                            "Please fill out the required field."}
                         </p>
                     </div>
                    <div className="col-3"></div>
                </div>

                <div className="row">
                    <div className="col-3"></div>
                    <div className="col-2 text-right">
                        <lable>Login:</lable>
                    </div>
                    <div className="col-4 d-grid gap-2 ">
                        <input
                            type="text"
                            name="login"
                            placeholder="Enter your login"
                            onChange={this.props.onHandleChange}
                        ></input>
                    </div>
                    <div className="col-3"></div>
                </div>

                <div className="row">
                    <div className="col-5"></div>
                    <div className="col-4">
                        <p className="color-red">
                            {this.props.loginRequired &&
                            "Please fill out the required field."}
                        </p>
                    </div>
                    <div className="col-3"></div>
                </div>

                <div className="row mb-4">
                    <div className="col-3"></div>
                    <div className="col-2 text-right">
                        <lable>Password:</lable>
                    </div>
                    <div className="col-4 d-grid gap-2 ">
                        <input
                            type="password"
                            name="password"
                            placeholder="Enter password"
                            onChange={this.props.onHandleChange}
                        ></input>
                    </div>
                    <div className="col-3"></div>
                </div>

                <div className="row">
                    <div className="col-3"></div>
                    <div className="col-6">
                        <p className="color-red text-center">
                            {this.props.enterInvalid &&
                            "Please make sure you are using a valid login or password"}
                        </p>
                    </div>
                    <div className="col-3"></div>
                </div>

                <div className="row">
                    <div className="col-7"></div>
                    <div className="col-2 d-grid gap-2">
                        <Button onClick={this.props.signin}>Enter</Button>
                    </div>
                    <div className="col-3"></div>
                </div>

            </div>
        )
    }
}