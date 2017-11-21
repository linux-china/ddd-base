package org.mvnsearch.ddd.domain.events;

import org.mvnsearch.ddd.domain.annotations.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * domain event: https://github.com/cncf/wg-serverless/tree/master/proposals/open-events
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
    protected Map<String, Object> attributes;
    /**
     * source
     */
    protected transient Object resource;
    /**
     * data
     */
    protected T data;
    /**
     * System time when the event happened
     */
    private final long createdAt;

    public BaseDomainEvent() {
        this.createdAt = System.currentTimeMillis();
    }

    public BaseDomainEvent(Object resource) {
        this.resource = resource;
        this.createdAt = System.currentTimeMillis();
    }

    public BaseDomainEvent(Object resource, T data) {
        this.resource = resource;
        this.data = data;
        this.createdAt = System.currentTimeMillis();
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

    public Object getResource() {
        return resource;
    }

    public void setResource(Object resource) {
        this.resource = resource;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public Object getAttribute(String name) {
        return attributes == null ? null : attributes.get(name);
    }

    public void setAttribute(String name, Object value) {
        if (attributes == null) {
            attributes = new HashMap<>();
        }
        this.attributes.put(name, value);
    }
}
