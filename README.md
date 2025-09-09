# Text History Service

A **Spring Boot** service that receives text messages from Kafka, stores them in **MongoDB**, and allows retrieving message history.  
This service works as a **Kafka consumer** and keeps track of all processed messages.

---

## Tech Stack
- Java 17
- Maven
- Spring Boot 3.5
- Spring Kafka
- Spring Data MongoDB
- Lombok
- Apache Kafka
- MongoDB
---

## Endpoints
- HTTP GET, Endpoint URL: /betvictor/history
- Returns 10 last measured records.
- Run endpoint to ```curl "http://localhost:8081/betvictor/history```
---

## Configuration

Main settings are located in `src/main/resources/application.properties`:

```properties
spring.application.name=texthistory.service

server.port=8081

spring.data.mongodb.uri=mongodb://localhost:27017/paragraph_result_db

spring.kafka.bootstrap-servers=localhost:9092
spring.kafka.consumer.group-id=paragraph-history-group
spring.kafka.consumer.auto-offset-reset=earliest
spring.kafka.consumer.enable-auto-commit=true
app.kafka-consumer-concurrency=3

app.kafka-topic=words.processed
```

- Change the number of threads (by default - 3) ```app.kafka-consumer-concurrency=3``` 
---

## Docker Compose
Docker-compose file is located `src/main/java/com/texthistory/service`

```
version: '3.8'

services:

  mongodb-history:
    image: mongo:6.0
    container_name: mongodb-history
    ports:
      - "27017:27017"
    volumes:
      - mongo_history_data:/data/db

volumes:
  mongo_history_data:

```
## Run the project
- ```docker-compose -p texthistory_service up -d```
- ```mvn clean install```
- ```mvn spring-boot:run```
---
## Connect to the MongoDB
Useful commands to test results directly in Mongo.

- ```show dbs```
- ```paragraph_result_db> show collections```
- ```paragraph_result_db> db.paragraph_results.find().pretty()```
- ```paragraph_result_db> db.paragraph_results.find().sort({ processedAt: -1 }).limit(10)```
