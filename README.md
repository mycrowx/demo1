# Demo 1

## Installation

For production environment

```bash
mvn package -DskipTests -Pprod
docker-compose -p demo1 -f prod.yml up
```

For development environment

```bash
mvn package -DskipTests -Pdev
docker-compose -p demo1 -f dev.yml up
```

## Usage

### Create a new user

```bash
http POST localhost:9000/user/user username=NguyenHoangNam password=123
```

### Login

```bash
http POST localhost:9000/user/user/login username=NguyenHoangNam password=123
```

### Get all users

```bash
http GET localhost:9000/user/user
```

## Service

### Gateway (Zuul)

localhost:9000
localhost:9000/actuator/\*
localhost:9000/user/user
localhost:9000/user/user/login
localhost:9000/movie/movie
localhost:9000/category/category

### Service-discovery (Eureka)

localhost:9999/eureka

### Config (Spring Cloud Config)

localhost:8011
localhost:8011/user/dev
localhost:8011/user/prod
localhost:8011/movie/dev
localhost:8011/movie/prod
localhost:8011/category/dev
localhost:8011/category/prod
localhost:8011/gateway/dev
localhost:8011/gateway/prod

Configuration can be updated by webhook and send to service by RabbitMQ.
However, webhook doesn't trust localhost so we can use Curl instead.

```bash
curl -v -X POST "http://localhost:8011/monitor" \
    -H "Content-Type: application/json" \
    -H "X-Event-Key: repo:push" \
    -H "X-Hook-UUID: webhook-uuid" \
    -d '{"push": {"changes": []} }'
```

### User (Spring Boot)

localhost:8010/user

### Movie (Spring Boot)

localhost:8080/movie

### Category (Spring Boot)

localhost:8081/category

### Python (Fast API)

localhost:8012/hello-user

### Tracing (Jaeger)

localhost:9091

### Monitoring (Prometheus)

localhost:9090

### Message Queue (Spring Cloud Bus + RabbitMQ)

localhost:15672
