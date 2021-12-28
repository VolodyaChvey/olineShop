### OnlineShop
The back-end part of the application starts with 
the command `mvn install tomcat7: run` from the command line.

1.To get a list of available products,you need to call an 
URL `http://localhost:8099/onlineshop/products` by GET-method.

2.To view the basket, you need to call an URL
`http://localhost:8099/onlineshop/basketItems` by GET-method

3.To add a product to the basket, you need to call an URL
`http://localhost:8099/onlineshop/basketItems/add` by 
POST-method with body containing product like 
`{"id": 1,"tittle": "Shirt","price": "22.59$"}` or any
 other product from the list of available products.
 
 4.To remove an item from the basket, you need to call an URL
 `http://localhost:8099/onlineshop/basketItems/del` by 
 POST-method with body containing product like 
 `{"id": 1,"tittle": "Shirt","price": "22.59$"}` or any
  other product from the list of available products.
 
 5.To confirm the order,you need to call an URL 
 `http://localhost:8099/onlineshop/orders` by POST-method
 which can be without body.
 
 6.To view the list of completing orders, you need to call
 an URL `http://localhost:8099/onlineshop/orders` by GET-method.
 
 
 The front-end part is in folder `client` make using `react.js`,
 so needs pre-installed `node.js`. From the command line, you
 need to run the command `npm install` for the possible need to
 install third-party libraries, then command `npm start` to
 start UI.