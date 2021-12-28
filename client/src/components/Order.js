import React from "react"
import TableHead from "./TableHead";
import TableBasket from "./TableBasket";

export default class Order extends React.Component{
    constructor(props){
        super(props);
        this.state={};
    }

    render(){
       
        return(
            <div className="row text-center py-2">
                <div className="col-5">
                    <TableHead order={this.props.order}></TableHead>
                </div>
                
                <div className="col-7">
                    <TableBasket order={this.props.order}></TableBasket>
                </div>

            </div>
        )
    }
}