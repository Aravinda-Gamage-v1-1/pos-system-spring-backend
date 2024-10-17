# POS System Spring Backend

This is a Spring-based backend system. This provides RESTful APIs for managing customers, items, orders, and transactions. This project uses Spring, JPA, Hibernate,Tomcat, and MySQL for database connectivity.


## Features

- **Inventory Management**: CRUD operations for managing products.
- **Sales**: Create Customer Orders.
- **Customer Management**: Add and manage customer profiles.
- **Logging**: Integrated logging for tracking events and debugging.
- **Layered Architecture**: Clear separation between presentation, business logic, and data layers.
- **REST API with JSON responses.**
- **Exception handling and validation using Spring Validator**.


## Technologies

- **Java Vesion:** JDK 17
- **Backend Framework:** Spring
- **Database:** MySQL
- **ORM:** JPA, Hibernate
- **Server:** Apache Tomcat 10.1.241


## Architecture
- **Entities:** Representations for Customer, Item, Order, and OrderDetail
- **Data Transfer Objects (DTOs):** Includes CustomerDTO, ItemDTO, and OrderDTO
- **Repositories:** Interfaces for database operations, such as CustomerRepository, ItemRepository, OrderRepository, and OrderDetailRepository
- **Services:** Business logic for managing customers, items, and orders in CustomerService, ItemService, and OrderService
- **Controllers:** API endpoints for handling customer, item, and order-related requests via CustomerController, ItemController, and OrderController
- **Utilities:** Helper classes for tasks like object mapping (Mapping) and application utilities (AppUtil)
- **Exceptions:** Custom error handling mechanisms for specific scenarios
- **Config Classes**:
    - **WebAppRootConfig**: Configuration related to application context.
    - **WebAppConfig**: Handles configurations related to the web layer (e.g., view resolver, resource handler).

## Endpoints

### Customer

- **GET /customers**: Retrieve all customers or Get a customer by ID.
- **POST /customers**: Create a new customer.
- **PUT /customers**: Update an existing customer.
- **DELETE /customers/{id}**: Delete a customer by ID.

### Item

- **GET /items**: Retrieve all items Get a item by Code.
- **POST /items**: Create a new item.
- **PUT /items**: Update an existing item.
- **DELETE /items/{id}**: Delete an item by Code.

### Order

- **POST /placeOrder**: Create a new order.
- **GET /placeOrder/allorders**: Retrieve all orders .


## Clone the repository:

```bash
  https://github.com/Aravinda-Gamage-v1-1/pos-system-spring-backend.git
```

## API Documentation

To view this project API Documentation

Refer to the [ Postman API Documentation](https://documenter.getpostman.com/view/36972880/2sAXxV7AuS) for detailed API endpoints and usage instructions.


## License

This project is licensed under the MIT License - see the [ MIT License](https://github.com/Aravinda-Gamage-v1-1/pos-system-spring-backend?tab=MIT-1-ov-file#) file for details.
