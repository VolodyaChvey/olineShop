import React from "react";
import { Button } from "react-bootstrap";
import BasketItem from "../components/BasketItem";
import Order from "../components/Order";
import Label from "../components/Label";

export default class BasketView extends React.Component{
    constructor(props){
        super(props);
        this.state = {};

        this.onShowItem = this.onShowItem.bind(this);
    }
    onShowItem(items){
        let content = [];
        for(let i = 0; i < items.length; i++ ){
            content.push(<div className="row">
                <div className="col-4"><BasketItem item={items[i++]}
                                                onClickAdd={this.props.onClickAdd}
                                                onClickLess={this.props.onClickLess}/></div>
                {items[i]&&<div className="col-4"><BasketItem item={items[i++]}
                                                            onClickAdd={this.props.onClickAdd}
                                                            onClickLess={this.props.onClickLess}/></div>}
                {items[i]&&<div className="col-4"><BasketItem item={items[i]}
                                                            onClickAdd={this.props.onClickAdd}
                                                            onClickLess={this.props.onClickLess}/></div>}
            </div>)
        }
        return content;
    }

    render(){
        return(
            <div>
                <div className="container">
                    <div className="row text-center my-4  buttons">
                        <div className="col-4 "><Button variant="success"
                                                        onClick>Log out</Button></div>
                        <div className="col-4 "><Button variant="success" 
                                                        onClick={this.props.toMenu}>Menu</Button></div>
                        <div className="col-4 "><Button variant="success"
                                                        onClick={this.props.toHistory}>History</Button></div>
                    </div>
                    <div className="row text-center my-4  ">
                        <div className="col-4 "></div>
                        <div className="col-4 "></div>
                        <div className="col-4 d-grid gap-2 "><Button variant="primary"
                                                        onClick={this.props.onClickToPay}>toPay</Button></div>
                    </div>
                    {this.props.items.length===0&&<Label text={this.props.text}></Label>}
                    {!this.props.order&&this.onShowItem(this.props.items)}
                    {this.props.order&&<Order order={this.props.order}></Order>}
                </div>

            </div>
        )
    }
}