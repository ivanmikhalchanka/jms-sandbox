#### Description
Sandbox project for exploring JMS

#### Set up
##### Using docker-compose:
2. Build using [Jib Maven Plugin](https://github.com/GoogleContainerTools/jib/tree/master/jib-maven-plugin):  
   `./mvnw package jib:dockerBuild`
3. Run docker-compose:
   `docker compose up -d`

##### Install ActiveMQ instead of using docker-compose:
1. [Install ActiveMQ](https://activemq.apache.org/getting-started.html)
   * MacOS: `brew install apache-activemq`
2. Start ActiveMQ:   
   * MacOS: `activemq start`

#### Modules
1. `jms-producer` - service with REST API for sending messages to JMS
   * [Actuator healthcheck](http://localhost:8081/actuator/health)
   * [Swagger UI](http://localhost:8081/swagger-ui/index.html)
2. `jms-consumer` - service with REST API for receiving messages from JMS
   * [Actuator healthcheck](http://localhost:8082/actuator/health)
   * [Swagger UI](http://localhost:8082/swagger-ui/index.html)