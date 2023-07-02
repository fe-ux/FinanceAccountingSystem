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
    ├── statisticsservice           # The service can view the statistics of its expenses and income 
    │                                 for a certain period, as well as receive the total amount of expenses and income.
    └── README.md
