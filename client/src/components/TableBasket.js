import React from "react"

export default class TableBasket extends React.Component{
    constructor(props){
        super(props);
        this.state={};
    }

    render(){
        const basletItems = this.props.order.items
            ?this.props.order.items
            :[];
        return(
            <div>
                <table  className="table table-bordered table-responsive table-hover">
                    <thead>
                        <tr>
                            <th>Items</th>
                        </tr>
                        <tr>
                            <th>ID</th>
                            <th>title</th>
                            <th>price</th>
                            <th>quantity</th>
                            <th>total</th>
                        </tr>
                    </thead>
                    <tbody>
                    {basletItems.map((item,i)=>
                            <tr>
                                <th>{item.id}</th>
                                <th>{item.tittle}</th>
                                <th>{item.price}</th>
                                <th>{item.quantity}</th>
                                <th>{item.total}</th>
                            </tr>
                    )}
                    </tbody>
                </table>
            </div>
        )
    }
}