import React from "react";
import { Button } from "react-bootstrap";
import Product from "../components/Product";

export default class ProductView extends React.Component{
    constructor(props){
        super(props);
        this.state = {
            products: [],
        };
        this.onShowProduct = this.onShowProduct.bind(this);
    }

    onShowProduct(items){
        let content = [];
        for(let i = 0; i < items.length; i++ ){
            content.push(<div className="row">
                <div className="col-4"><Product product={items[i++]}
                                                onClickAdd={this.props.onClickAdd}/></div>
                {items[i]&&<div className="col-4"><Product product={items[i++]}                                            
                                                            onClickAdd={this.props.onClickAdd}/></div>}
                {items[i]&&<div className="col-4"><Product product={items[i]}                                           
                                                            onClickAdd={this.props.onClickAdd}/></div>}
            </div>)
        }
        return content;
    }

    render(){
        return (
            <div>
                <div className="container">
                    <div className="row text-center my-4  buttons">
                        <div className="col-4 "><Button variant="success"
                                                        onClick={this.props.toLogout}>Log out</Button></div>
                        <div className="col-4 "><Button variant="success" 
                                                        onClick={this.props.toBasket}>Basket</Button></div>
                        <div className="col-4 "><Button variant="success"
                                                        onClick={this.props.toHistory}>History</Button></div>
                    </div>
                    {this.onShowProduct(this.props.products)}
                </div>
            </div>
        )
    }
}