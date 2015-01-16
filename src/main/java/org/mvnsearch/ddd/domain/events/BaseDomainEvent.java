package org.mvnsearch.ddd.domain.events;

import org.mvnsearch.ddd.domain.BaseModel;
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
public class BaseDomainEvent<T extends BaseModel> implements Serializable {
    protected Map<String, Object> context = new HashMap<String, Object>();
    /**
     * uuid for event
     */
    protected String id;
    /**
     * event type
     */
    protected String type;
    /**
     * source
     */
    protected T source;
    /**
     * occurred timestamp
     */
    protected long occurredOn;

    public BaseDomainEvent() {
        this.occurredOn = System.currentTimeMillis();
        this.id = occurredOn + "-" + UUID.randomUUID().toString();
    }

    public BaseDomainEvent(String type, T source) {
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
