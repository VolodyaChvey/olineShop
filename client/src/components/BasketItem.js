import React from "react";
import { Card } from "react-bootstrap";

export default class BasketItem extends React.Component{
    constructor(props){
        super(props);
        this.state = {};
    }

    render(){

        return(
            <div className="my-2 text-center">
                <Card bg="info" className="VieBasket">
                    <Card.Body >
                        <Card.Title>{this.props.item.tittle}</Card.Title>
                        <Card.Text>{"Quantity:  "+ this.props.item.quantity}</Card.Text>
                        <Card.Text>{"Total:  "+this.props.item.total+"$"}</Card.Text>
                    </Card.Body>
                </Card>
            </div>
        )
    }
}