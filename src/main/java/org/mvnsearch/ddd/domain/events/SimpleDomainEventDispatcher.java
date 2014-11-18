package org.mvnsearch.ddd.domain.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * simple domain event bus implementation
 *
 * @author linux_china
 */
public class SimpleDomainEventDispatcher implements DomainEventDispatcher {
    private static final Logger log = LoggerFactory.getLogger(SimpleDomainEventDispatcher.class);
    private Set<EventHandler> eventHandlers = new HashSet<EventHandler>();

    public void setEventHandlers(Set<EventHandler> eventHandlers) {
        this.eventHandlers = eventHandlers;
    }

    /**
     * register event handler
     *
     * @param handler event handler
     */
    public void registerEventHandler(EventHandler handler) {
        eventHandlers.add(handler);
    }

    /**
     * publish domain event
     *
     * @param domainEvent domain event
     */
    public void publish(BaseDomainEvent domainEvent) {
        doPublish(domainEvent);
    }

    /**
     * domain publish logic
     *
     * @param event domain event
     */
    protected void doPublish(BaseDomainEvent event) {
        for (EventHandler handler : new ArrayList<EventHandler>(eventHandlers)) {
            if (handler.canHandle(event)) {
                try {
                    handler.handle(event);
                } catch (Exception e) {
                    log.error("event handling error", e);
                }
            }
        }
    }


}
