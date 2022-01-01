import React from "react";

export default class TableHead extends React.Component{
    constructor(props){
        super(props);
        this.state={};
    }
    render(){
        return(
            <div>
                <table className="table table-bordered table-responsive table-hover">
                    <thead className="firstThead">
                        <tr>
                            <th>ID</th>
                            <th>OrderPrice</th>
                            <th>Timestamp</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <th>{this.props.order.id}</th>
                            <th>{this.props.order.orderPrice}</th>
                            <th>{new Date(this.props.order.timestamp).toLocaleString("en-GB", {
                                     year: "numeric",
                                     month: "numeric",
                                     day: "numeric",
                                     hour: "2-digit",
                                     minute: "2-digit",
                                     second: "2-digit",
                                     hour12: false,
                                     })}</th>
                        </tr>
                    </tbody>
                </table>
            </div>
        
        )}
}