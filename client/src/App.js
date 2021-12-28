import React from "react";
import { Route, Switch } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';
import "./App.css"
import Products from "./containers/Products";
import Basket from "./containers/Basket";
import History from "./containers/History";

function App() {
  return (
    <div>
      <Switch>
        <Route exact path='/' component={Products}/>
        <Route path='/basket' component={Basket}/>
        <Route path='/history' component={History}/>
      </Switch>
 
    </div>
  );
}

export default App;
