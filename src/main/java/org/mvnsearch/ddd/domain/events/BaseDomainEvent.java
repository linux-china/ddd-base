package org.mvnsearch.ddd.domain.events;

import org.mvnsearch.ddd.domain.annotations.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * domain event
 *
 * @author linux_china
 */
@DomainEvent
public class BaseDomainEvent<T> implements Serializable {
    private static final long serialVersionUID = 5516075349620653482L;
    /**
     * ID
     */
    private String id = UUID.randomUUID().toString();
    /**
     * event type
     */
    protected String type;
    /**
     * event context
     */
    protected Map<String, Object> context;
    /**
     * source
     */
    protected transient Object source;
    /**
     * payload
     */
    protected T payload;
    /**
     * System time when the event happened
     */
    private final long timestamp;


    public BaseDomainEvent() {
        this.timestamp = System.currentTimeMillis();
    }

    public BaseDomainEvent(Object source) {
        this.source = source;
        this.timestamp = System.currentTimeMillis();
    }

    public BaseDomainEvent(Object source, T payload) {
        this.source = source;
        this.payload = payload;
        this.timestamp = System.currentTimeMillis();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getSource() {
        return source;
    }

    public void setSource(Object source) {
        this.source = source;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public Object getAttribute(String name) {
        return context == null ? null : context.get(name);
    }

    public void setAttribute(String name, Object value) {
        if (context == null) {
            context = new HashMap<String, Object>();
        }
        this.context.put(name, value);
    }
}
