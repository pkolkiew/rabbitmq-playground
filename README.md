# rabbitmq-playground
Playground for integrating RabbitMQ with Spring Cloud Stream

## Curl example:

```
curl -d '{"messageBody":"testowa wiadomosc"}' -H "Content-Type: application/json" -X POST http://localhost:8080/message/publish
```
