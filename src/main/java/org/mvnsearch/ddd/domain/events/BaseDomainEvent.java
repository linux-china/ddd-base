package org.mvnsearch.ddd.domain.events;

import org.mvnsearch.ddd.domain.BaseEntity;
import org.mvnsearch.ddd.domain.annotations.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * base domain event for entity or aggregate
 *
 * @author linux_china
 */
@DomainEvent
public class BaseDomainEvent<T extends BaseEntity> implements Serializable {
    protected Map<String, Object> context = new HashMap<String, Object>();
    protected T source;
    /**
     * occurred timestamp
     */
    private long occurredOn;
    /**
     * uuid for event
     */
    private String id;

    public BaseDomainEvent() {
        this.occurredOn = System.currentTimeMillis();
        this.id = occurredOn + "-" + UUID.randomUUID().toString();
    }

    public BaseDomainEvent(T source) {
        this.source = source;
        this.occurredOn = System.currentTimeMillis();
        this.id = occurredOn + "-" + UUID.randomUUID().toString();
    }

    /**
     * get event id
     *
     * @return event event id with timeuuid format
     */
    public String getId() {
        return this.id;
    }

    public T getSource() {
        return source;
    }

    public void setSource(T source) {
        this.source = source;
    }

    public long getOccurredOn() {
        return occurredOn;
    }

    public void setOccurredOn(long occurredOn) {
        this.occurredOn = occurredOn;
    }

    public Object getAttribute(String name) {
        return context.get(name);
    }

    public void setAttribute(String name, Object value) {
        this.context.put(name, value);
    }
}
