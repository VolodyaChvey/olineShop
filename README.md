### OnlineShop
The back-end part of the application.

 The application uses the authentication type: *Basic Auth*.
 There are 3 scenarios for the user:
 - Login: _Vasya_  Password: _P@ssword1_
 - Login: _Petya_  Password: _P@ssword1_
 - Login: _Kolya_  Password: _P@ssword1_
 
 
In the root folder of the project, execute: 
 `mvn clean install tomcat7:run` to run the application.
 
 After that, you can send requests to `http://localhost:8099/OnlineShop` 
 at the endpoints: 

1.To get a list of available products,you need to call 
at the endpoint `/products` by GET-method.

2.To view the basket, you need to call at the endpoint
`/orders/basketItems` by GET-method

3.To add a product to the basket, you need to call at the endpoint
`/orders/basketItems/add` by POST-method with body containing product
 like `{"id": 1,"tittle": "Shirt","price": "22.59$"}` or any
 other product from the list of available products.
 
 4.To remove an item from the basket, you need to call at the endpoint
 `/orders/basketItems/del` by POST-method with body containing product 
 like `{"id": 1,"tittle": "Shirt","price": "22.59$"}` or any other of 
 your chosen products.
 
 5.To confirm the order,you need to call at the endpoint
  `/orders`by POST-method which can be without body.
 
 6.To view the list of completing orders, you need to call 
 at the endpoint `/orders` by GET-method.
 
 
 The front-end part is in folder `client` make using `react.js`,
 so needs pre-installed `node.js`. From the command line, you
 need to run the command `npm install` for the possible need to
 install third-party libraries, then command `npm start` to
 start UI.