DDD Base
========================================
Domain Driven Design base package for Java.

### How to use?

please refer https://jitpack.io/#linux-china/ddd-base/1.0.6 

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

If you use Kotlin to develop application, the structure will be different, please add entity, vo and repository in the same kt file.

### Event Sourcing

Please extends BaseDomainEvent and use ApplicationEventPublisher to publish event.

please refer https://spring.io/blog/2015/02/11/better-application-events-in-spring-framework-4-2
