# rabbitmq-playground
Playground for integrating RabbitMQ with Spring Cloud Stream

## Curl:

Curl to publish messages to queue

```
curl -d '{"messageBody":"testowa wiadomosc"}' -H "Content-Type: application/json" -X POST http://localhost:8080/message/publish
```
