import React from "react";
import axios from "axios";
import history from "../history";
import BasketView from "../view/BasketView";

export default class Basket extends React.Component{
    constructor(props){
        super(props);
        this.state = {
            order: false,
            items: [],
        };

        this.toMenu = this.toMenu.bind(this);
        this.toHistory = this.toHistory.bind(this);
        this.onClickToPay = this.onClickToPay.bind(this);
    }

    toMenu(){
        history.push('/')
    }

    toHistory(){
        history.push('/history')
    }

    onClickToPay(){
        axios
            .post("http://localhost:8099/OnlineShop/orders")
            .then((resp)=>{
                this.setState({order: resp.data})
                console.log(this.state.order)
            })
    }

    componentDidMount(){
        axios
            .get("http://localhost:8099/OnlineShop/basketItems")
            .then((resp)=>{
                this.setState({items: resp.data})
                
            })
    }



    render(){
        return(
            <div>
                <BasketView
                    order={this.state.order}
                    items={this.state.items}
                    onClickToPay={this.onClickToPay}
                    toMenu={this.toMenu}
                    toHistory={this.toHistory}
                ></BasketView>
            </div>
        )
    }
}