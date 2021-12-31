import React from "react";
import axios from "axios";
import history from "../history";
import ProductView from "../view/ProductsView";


export default class Products extends React.Component{
    constructor(props){
        super(props);
        this.state = {
            products: [],
        };
        this.onClickAdd = this.onClickAdd.bind(this);
        this.toBasket = this.toBasket.bind(this);
        this.toHistory = this.toHistory.bind(this);
    }

    onClickAdd(e){
        let p = this.state.products[e.target.id-1]
        axios
         .post("http://localhost:8099/OnlineShop/orders/basketItems/add",p)
         .then((resp)=>{
                
         })
    }
    toHistory(){
        history.push("/history")
    }

    toBasket(){
        history.push("/basket");
    }

    componentDidMount(){
     axios
         .get("http://localhost:8099/OnlineShop/products")
         .then((resp)=>{
             this.setState({products: resp.data})
     })
    }

    render(){

        return (
            <div>
                <ProductView
                   
                     products={this.state.products}
                     toHistory={this.toHistory}
                     toBasket={this.toBasket}
                     onClickAdd={this.onClickAdd}/>
            </div>
        );
    }
}