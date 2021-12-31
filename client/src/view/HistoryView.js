import React from "react";
import Order from "../components/Order";
import { Button } from "react-bootstrap";
import Label from "../components/Label";

export default class HistoryView extends React.Component{
    constructor(props){
        super(props);
        this.state={};
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
                                                        onClick={this.props.toBasket}>Basket</Button></div>
                    </div>
                    {this.props.orders.map((o,i)=>
                        <Order order={o}></Order>
                    )}
                    {this.props.orders.length===0 && <Label text={this.props.text}></Label>}
                </div>
            </div>
        )
    }
}