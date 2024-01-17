# QEats Food Order App

## Intro & Goal:
Our goal is to build a Restaurant App for QEats to help restaurant owners and managers in
managing their menu (items, availability, prices), order preparation time, order status, order
history, and order notifications (like the arrival of order and/or cancellation of orders). This
application will provide restaurant owners (or managers) a seamless and easy-to-use
interface for managing their restaurant over QEats platform. By providing intuitive and easy
access for restaurant owners (or managers) will result in an increase in the number of
restaurants over QEats.

Why build it?
1. With the increase in adaptation and penetration of technology, it is necessary for
   restaurant businesses to adapt and incorporate such technology in managing orders
   easily.
2. With the high reachability of restaurants via online food ordering app, it is
   tremendously difficult for restaurants to manage orders without any technical
   solution.
3. Easy management of restaurant menu and updating the menu items
4. Quick update of availability of menu items based on the physical constraints
5. Updation of time of preparation on an item, to provide ETA of orders for the
   customers
6. Quick update of the status of orders and intimidation to users
7. To improve delivery time and quality of food by taking constant feedbacks
8. For providing order history for later reference of restaurant owners
9. For providing relevant statistics of the restaurant, so that they the owner can make
   the required decisions for increasing the business.


### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.1/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.1/maven-plugin/reference/html/#build-image)
* [Rest Repositories](https://docs.spring.io/spring-boot/docs/3.2.1/reference/htmlsingle/index.html#howto.data-access.exposing-spring-data-repositories-as-rest)
* [Spring Data JDBC](https://docs.spring.io/spring-boot/docs/3.2.1/reference/htmlsingle/index.html#data.sql.jdbc)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.2.1/reference/htmlsingle/index.html#web)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.2.1/reference/htmlsingle/index.html#data.sql.jpa-and-spring-data)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.2.1/reference/htmlsingle/index.html#using.devtools)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/3.2.1/reference/htmlsingle/index.html#actuator)

### Guides

The following guides illustrate how to use some features concretely:

* [Accessing JPA Data with REST](https://spring.io/guides/gs/accessing-data-rest/)
* [Accessing Neo4j Data with REST](https://spring.io/guides/gs/accessing-neo4j-data-rest/)
* [Accessing MongoDB Data with REST](https://spring.io/guides/gs/accessing-mongodb-data-rest/)
* [Using Spring Data JDBC](https://github.com/spring-projects/spring-data-examples/tree/master/jdbc/basics)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)
* [Swagger and Spring Security](https://medium.com/turkcell/swagger-with-spring-boot-and-security-cf8585dcf3b2)


Users
-Type
-Name
-DOB
-Mobile
-Email

UserType
-ADMIN
-NORMAL

Agents
-Type
-Name
-DOB
-Mobile
-Email

Restuarant
-Name
-Address
-Email
-Mobile
-GST
-Admin

User_Address
-StreetName
-City
-State
-CodePin
-UserId

Restuarant_Address
-StreetName
-City
-State
-CodePin
-Restuarant_Id
 

Menu
-Item
-Discount

Item
-Name
-Price
-Attributes
-Menu


Menu_Item_Availability
-Restuarant_
-Item
-Quantity

Orders
-Order_Items
-Amount
-PaymentStatus
-PaymentMode
-OrderStatus
-Users
-User_Address
-Agents

Order_Items
-Order
-Items

PaymentMode
-Credit/Debit
-Cash

PaymentStatus
-Processing
-Paid

OrderStatus
-Accepted
-Rejected
-Preparing foods
-Out for Delivery
-Delivered






