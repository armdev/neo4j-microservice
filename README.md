# neo4j-microservice
neo4j microservice

1. Edit database path in src\main\resources\config.yml
2. cd neo4j-microservice
3. mvn clean package -U
4. java -jar target/neo4j-micro.jar server src/main/resources/config.yml
5. Access: http://localhost:9090/swagger
6. HealthCheck: http://localhost:9091/healthcheck?pretty=true
7. Metrics: http://localhost:9091/metrics?pretty=true
