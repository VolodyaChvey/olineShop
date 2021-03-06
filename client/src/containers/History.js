import axios from "axios";
import React from "react";
import HistoryView from "../view/HistoryView";
import history from "../history";

export default class History extends React.Component{
    constructor(props){
        super(props);
        this.state={
            orders: [],
            text: "No completed Orders",
        };
        this.toMenu = this.toMenu.bind(this);
        this.toBasket = this.toBasket.bind(this);
        this.toLogout = this.toLogout.bind(this);
    }

    toLogout(){
        localStorage.clear();
        history.push('/')
    }

    toMenu(){
        history.push('/product')
    }

    toBasket(){
        history.push('/basket')
    }

    componentDidMount(){
        axios
         .get("http://localhost:8099/OnlineShop/orders",
                JSON.parse(localStorage.AuthHeader) )
         .then((resp)=>{
            this.setState({orders: resp.data})
         })
    }

    render(){
        return(
            <div>
                <HistoryView orders={this.state.orders}
                            text={this.state.text}
                            toLogout={this.toLogout}
                            toMenu={this.toMenu}
                            toBasket={this.toBasket}/>
            </div>
        )
    }
}