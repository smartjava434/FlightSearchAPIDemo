# Flight Search API

The Flight search api finds flights based on source, destination and sorts the response based on duration and/or price in the ascending order.


## Project Description
This project finds the list of flights based on passing the query parameters to endpoint.

Below are the query parameters 

1.source 

2.destination

3.sortType(price,destination,price_destination) 



## Requirements

For building and running the application you need:

- [JDK 11]
- [Maven]
- [Spring Boot 2.5.2]



## Running the application locally

 you can run directly as Run as Springboot Application


## END POINT for the service

To see the data in H2 database
http://localhost:8080/h2-console/

To test the API 
http://localhost:8080/flights?origin=<Origin>&destination=<Destination>&sortType=<SortType>
We can pass the required Origin ,Destination and Sort Type

Examples:

1) http://localhost:8080/flights?origin=BOM&destination=DEL&sortType=price

2)http://localhost:8080/flights?origin=BOM&destination=DEL&sortType=duration

3)http://localhost:8080/flights?origin=BOM&destination=DEL&sortType=price_duration

## Test Case Implementation

We have implemented Test cases using JUNIT5 and Mockito
To Cover the all the source in the Test Coverage, we implemented several test cases. So that the API will be bug-less for deployment.


## License
Its sample implementation which is developed by all free source