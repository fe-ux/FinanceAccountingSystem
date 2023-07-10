Finance Accounting System
============================

> Project for accounting of financial transactions, expenses and income

### A top-level directory layout

    .
    ├── PostgerSQL                  # Files for initial database
    ├── Kafka                       # Files for create Kafka topics
    ├── LogsSchemes                 # The scheme of the project device and service verification reports
    ├── managementservice           # Microservice for adding/deleting/receiving financial transactions
    ├── generationservice           # Microservice that generates users with expenses and income
    ├── statisticsservice           # Microservice can view the statistics of its expenses and income 
    │                                 for a certain period, as well as receive the total amount of expenses and income.
    ├── eurekaserver                # Service discovery for microservices. Client applications can register themselves 
    │                                  in it, and other microservices can contact Eureka Server to find the 
    │                                  microservices they need
    ├── apigetway                   # API Gateway allows you to configure separate processing and access for each part 
    │                                 of the API endpoint address
    ├── authorizationservice        # Microservice microservice provides user registration and authentication functions.
    ├── notificationservice         # Microservice sends a notification on a transaction
    │                               
    └── README.md
