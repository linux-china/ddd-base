package org.mvnsearch.ddd.domain.events;


import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * domain event: https://github.com/cncf/wg-serverless/tree/master/proposals/open-events
 *
 * @author linux_china
 */
public class DomainEvent<T> {
    /**
     * ID
     */
    private String id = UUID.randomUUID().toString();
    /**
     * event type
     */
    private String type;
    /**
     * event context
     */
    private Map<String, Object> attributes;
    /**
     * source
     */
    private transient Object source;
    /**
     * data
     */
    private T data;
    /**
     * System time when the event happened
     */
    private final long createdAt;

    public DomainEvent() {
        this.createdAt = System.currentTimeMillis();
    }

    public DomainEvent(T data) {
        this.data = data;
        this.createdAt = System.currentTimeMillis();
    }

    public DomainEvent(String type, T data) {
        this.type = type;
        this.data = data;
        this.createdAt = System.currentTimeMillis();
    }

    public DomainEvent(String type, T data, Object source) {
        this.type = type;
        this.data = data;
        this.source = source;
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

    public Object getSource() {
        return source;
    }

    public void setSource(Object source) {
        this.source = source;
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
