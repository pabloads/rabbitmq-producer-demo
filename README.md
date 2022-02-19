# rabbitmq-producer-demo

This application sends messages to RabbitMQ. 

# Tools used

- Spring Boot
- Kotlin
- Gradle
- RabbitMQ
- Spring Cloud Sleuth
- Swagger with OpenAPI

# How to run this application

1° - In the terminal, run the following commands:
```
docker pull rabbitmq

docker run -d --hostname localhost --name local-rabbit -p 15672:15672 -p 5672:5672 rabbitmq:3-management
```

3° - RabbitMQ Management will is available at:
```
http://localhost:15672/#/

user: guest
password: guest
```

2° - Run application on IDE.

3° - Swagger will is available at:
```
http://localhost:8001/swagger-ui/index.html
```