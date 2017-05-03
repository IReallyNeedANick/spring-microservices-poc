# Spring Cloud Microservice PoC


This is a PoC that show how different technologies interact. Build on top of Dalston.RELEASE train

Spring cloud libraries used:
 - [Spring Cloud Feign](http://projects.spring.io/spring-cloud/spring-cloud.html#spring-cloud-feign) 
 - [Spring Cloud Eureka](http://projects.spring.io/spring-cloud/spring-cloud.html#spring-cloud-eureka-server)
 - [Spring Cloud Config server](https://cloud.spring.io/spring-cloud-config/spring-cloud-config.html)
 - [Zuul gateway](https://github.com/Netflix/zuul/wiki/Getting-Started)
 - [Spring Authorization Server](http://docs.spring.io/spring-boot/docs/2.0.0.BUILD-SNAPSHOT/reference/htmlsingle/#boot-features-security-oauth2-authorization-server)
 - [Spring Cloud Hystrix](https://github.com/Netflix/Hystrix/wiki)

## Starting Application

//TODO add picture

//TODO add run priority (basically just say Configuration server must be first :)
 
//TODO add postman call example

## Configuration server

We use configuration-first approach. This means we must run @ConfigurationServer before running any other microservice. 

To get configuration for spring-application-name=HELLO_SERVICE and profile=DEVELOPMENT we only need to call URL `GET=http://localhost:9009/HELLO_SERVICE/DEVELOPMENT`

Microservices must have at minimal dependency in pom.xml:
```
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-config</artifactId>
        </dependency>
```
And these two properties set in bootstrap.properties:
```
spring.application.name=${microservice-name}
spring.cloud.config.uri=http://localhost:9009
```


##Eureka server

To see all registered microservices call `GET=localhost:8761`. 

If we want to run multiple instances of particular microservice we must uncomment 
```
eureka.instance.instance-id=${spring.application.name}:${vcap.application.instance_id:${spring.application.instance_id:${random.value}}}
```

This is commented because logic for handling dead microservices is by default quite complex and I didn't put much thought into it.
If this is commented out new service will replace old one and there will be no dead microservices lingering in the background. 

Services that want to register with Eureka must have configuration annotated with `@EnableEurekaClient`

## Zuul gateway

All Client calls should go through localhost:8080.

If microservice name is=HELLO_MICROSERVICE then we call `localhost:8080/HELLO_MICROSERVICE `


All eureka registered services can be called for now.

## Authorization server

Security is stateless and OAUTH2 JWT compliant. Other services validate token by getting public key from @AuthorizationServer

Services secured with @AuthorizationServer must have at minimal annotation `@EnableResourceServer` and link to public key (for example `security.oauth2.resource.jwt.key-uri=http://localhost:8081/oauth/token_key`)
 
##monitoring 

you must have rabbitMQ installed with default settings.

go to http://localhost:8079/hystrix

write url http://localhost:8989/turbine.stream

watch how requests play out.

##tracing

//TODO
