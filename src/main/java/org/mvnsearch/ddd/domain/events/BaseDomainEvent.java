package org.mvnsearch.ddd.domain.events;

import org.mvnsearch.ddd.domain.BaseEntity;
import org.mvnsearch.ddd.domain.annotations.DomainEvent;

import java.io.Serializable;
import java.util.Date;
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
     * occured timestamp
     */
    private Date occuredAt;
    /**
     * uuid for event
     */
    private String timeuuid;

    public BaseDomainEvent() {
        this.occuredAt = new Date();
        this.timeuuid = occuredAt.getTime() + "-" + UUID.randomUUID().toString();
    }

    public BaseDomainEvent(T source) {
        this.source = source;
        this.occuredAt = new Date();
        this.timeuuid = occuredAt.getTime() + "-" + UUID.randomUUID().toString();
    }

    /**
     * get event id
     *
     * @return event event id with timeuuid format
     */
    public String getId() {
        return this.timeuuid;
    }

    public T getSource() {
        return source;
    }

    public void setSource(T source) {
        this.source = source;
    }

    public Date getOccuredAt() {
        return occuredAt;
    }

    public void setOccuredAt(Date occuredAt) {
        this.occuredAt = occuredAt;
    }

    public Object getAttribute(String name) {
        return context.get(name);
    }

    public void setAttribute(String name, Object value) {
        this.context.put(name, value);
    }
}
