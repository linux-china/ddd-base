package org.mvnsearch.ddd.domain.events;

/**
 * domain event bus
 *
 * @author linux_china
 */
public interface DomainEventDispatcher {
    /**
     * publish domain event
     *
     * @param domainEvent domain event
     */
    void publish(BaseDomainEvent domainEvent);

    /**
     * register event handler
     *
     * @param handler event handler
     */
    public void registerEventHandler(DomainEventHandler handler);

}
