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

Please visit [src/test/java](https://github.com/linux-china/ddd-base/tree/master/src/test/java/org/mvnsearch/demo/domain) for code structure

### Event Sourcing

Please extends BaseDomainEvent and use ApplicationEventPublisher to publish event.

please refer https://spring.io/blog/2015/02/11/better-application-events-in-spring-framework-4-2
