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
            text: "Basket is empty"
        };

        this.toMenu = this.toMenu.bind(this);
        this.toHistory = this.toHistory.bind(this);
        this.toLogout = this.toLogout.bind(this);
        this.onClickToPay = this.onClickToPay.bind(this);
        this.onClickLess = this.onClickLess.bind(this);
        this.onClickAdd = this.onClickAdd.bind(this);
    }

    toLogout(){
        localStorage.clear();
        history.push('/')
    }

    toMenu(){
        history.push('/product')
    }

    toHistory(){
        history.push('/history')
    }
    onClickLess(e){
        let item = this.state.items.filter(i =>i.productId==e.target.id)[0];
        let p={};
        p.id=item.productId;
        p.tittle=item.tittle;
        p.price=item.price;
        axios
         .post("http://localhost:8099/OnlineShop/orders/basketItems/del",p,
                 JSON.parse(localStorage.AuthHeader))
         .then((resp)=>{
                axios
                .get("http://localhost:8099/OnlineShop/orders/basketItems",
                     JSON.parse(localStorage.AuthHeader))
                .then((resp)=>{
                    this.setState({items: resp.data})  
            })
         })
         .catch((resp)=>{
         })
    }

    onClickAdd(e){
        let item = this.state.items.filter(i =>i.productId==e.target.id)[0];
        let p={};
        p.id=item.productId;
        p.tittle=item.tittle;
        p.price=item.price;
        axios
         .post("http://localhost:8099/OnlineShop/orders/basketItems/add",p,
            JSON.parse(localStorage.AuthHeader))
         .then((resp)=>{
             axios
                .get("http://localhost:8099/OnlineShop/orders/basketItems",
                    JSON.parse(localStorage.AuthHeader))
                .then((resp)=>{
                     this.setState({items: resp.data})  
            })  
         })
    }

    onClickToPay(){
        axios
            .post("http://localhost:8099/OnlineShop/orders",null,
                 JSON.parse(localStorage.AuthHeader))
            .then((resp)=>{
                this.setState({order: resp.data})
                console.log(this.state.order)
            })
    }

    componentDidMount(){
        axios
            .get("http://localhost:8099/OnlineShop/orders/basketItems",
                 JSON.parse(localStorage.AuthHeader))
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
                    text={this.state.text}
                    onClickAdd={this.onClickAdd}
                    onClickLess={this.onClickLess}
                    onClickToPay={this.onClickToPay}
                    toMenu={this.toMenu}
                    toHistory={this.toHistory}
                    toLogout={this.toLogout}
                ></BasketView>
            </div>
        )
    }
}