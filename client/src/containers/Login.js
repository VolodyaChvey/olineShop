import React from "react";
import LoginView from "../view/LoginView";
import axios from "axios";
import history from "../history";

export default class Login extends React.Component{
    constructor(props){
        super(props);
        this.state = {
            login: "",
            password: "",
            loginRequired: false,
            passwordRequired: false,
            enterInvalid: false,
        };
        
        this.createHeader = this.createHeader.bind(this);
        this.onHandleChange = this.onHandleChange.bind(this);
        this.signin = this.signin.bind(this);
        this.onCompletedFields = this.onCompletedFields.bind(this);
    }

    onHandleChange(e){
        e.preventDefault();
        this.setState({ [e.target.name]: e.target.value });
        this.setState({enterInvalid:false});
        if(e.target.name==="login"){
          this.setState({loginRequired: false})
        }
        if(e.target.name==="password"){
          this.setState({passwordRequired: false})
        }

    }

    createHeader(){
        let authValue = btoa(this.state.login + ":" + this.state.password);
        return { headers: {Authorization: "Basic " + authValue}};
    }

    signin(e) {
        e.preventDefault();
        if(this.onCompletedFields()){
        axios
          .get("http://localhost:8099/OnlineShop/users/current", this.createHeader())
          .then((resp) => {
            localStorage.setItem("AuthHeader", JSON.stringify(this.createHeader()));
            localStorage.setItem("User", JSON.stringify(resp.data));
            history.push("/product");
          })
          .catch((error) => {
            this.setState({enterInvalid: true});
          });
        }else{
          this.setState({enterInvalid: true});
        }
    }

    onCompletedFields(){
        if(!this.state.login){
            this.setState({loginRequired:true});
            return false;
        }else{
          this.setState({loginRequired:false})
        }
        if(!this.state.password){
          this.setState({passwordRequired:true});
          return false;
        }else{
          this.setState({passwordRequired:false})
        }
        return true;
    }

    render(){
        return(
            <div>
                <LoginView
                    onHandleChange={this.onHandleChange}
                    signin={this.signin}
                    loginRequired={this.state.loginRequired}
                    passwordRequired={this.state.passwordRequired}
                    enterInvalid={this.state.enterInvalid}
                ></LoginView>
            </div>
        )
    }
}