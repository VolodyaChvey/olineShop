import axios from "axios";
import React from "react";
import HistoryView from "../view/HistoryView";
import history from "../history";

export default class History extends React.Component{
    constructor(props){
        super(props);
        this.state={
            orders: [],
        };
        this.toMenu = this.toMenu.bind(this);
        this.toBasket = this.toBasket.bind(this);
    }

    toMenu(){
        history.push('/')
    }

    toBasket(){
        history.push('/basket')
    }

    componentDidMount(){
        axios
         .get("http://localhost:8099/OnlineShop/orders")
         .then((resp)=>{
            this.setState({orders: resp.data})
         })
    }

    render(){
        return(
            <div>
                <HistoryView orders={this.state.orders}
                             toMenu={this.toMenu}
                             toBasket={this.toBasket}/>
            </div>
        )
    }
}