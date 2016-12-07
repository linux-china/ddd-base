DDD Base
========================================
Domain Driven Design base package for Java.


### Features

* Annotations
* base classes for entity, domain event etc
* domain event
* spring annotation integration???

### Components

* Data: Entity, VO and Aggregate
* Behaviour: Repository, Service, Factory and Specification
* Event
* Infrasturcture

### Code Structure

Please visit src/test/java for code structure

### event sourcing

Please extends BaseDomainEvent and use ApplicationEventPublisher to publish event.

please refer https://spring.io/blog/2015/02/11/better-application-events-in-spring-framework-4-2

