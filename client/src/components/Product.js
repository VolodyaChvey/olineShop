import React from "react";
import { Button, Card } from "react-bootstrap";

export default class Product extends React.Component{
    constructor(props){
        super(props);
        this.state = {};
    }
    render(){
        return(
            <div className="my-2 text-center">
                <Card bg="info" className="Vie">
                    <Card.Img variant="top" src={"img"+(this.props.product.id-1) +".jpg"} height={250} width={100} alt={this.props.product.tittle}></Card.Img>
                    <Card.Body>
                        <Card.Title>{this.props.product.tittle}</Card.Title>
                        <Card.Text>Price  {this.props.product.price}</Card.Text>
                        <div>
                            <Button variant="primary" onClick={this.props.onClickAdd}
                                                    id={this.props.product.id}>Add</Button>{' '}
                             <Button variant="primary" onClick={this.props.onClickLess}
                                                     id={this.props.product.id}>Less</Button>
                        </div>
                    </Card.Body>
                </Card>
               
            </div>
        )
    }
}