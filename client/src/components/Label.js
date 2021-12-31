import React from "react";

export default class Label extends React.Component{
    constructor(props){
        super(props);
        this.state = {};
    }

    render(){
        return(
            <div className="text-center label">
                {this.props.text}
            </div>
        )
    }
}