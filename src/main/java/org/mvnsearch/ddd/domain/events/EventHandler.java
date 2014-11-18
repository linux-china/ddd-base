package org.mvnsearch.ddd.domain.events;

/**
 * event handler
 *
 * @author linux_china
 */
public interface EventHandler {

    /**
     * can handle event indication
     *
     * @param event domain event
     * @return handle indication
     */
    boolean canHandle(BaseDomainEvent event);

    /**
     * handle logic
     *
     * @param event domain event
     */
    void handle(BaseDomainEvent event);
}