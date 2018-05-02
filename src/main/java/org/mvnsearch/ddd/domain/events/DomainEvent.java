package org.mvnsearch.ddd.domain.events;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * domain event from CloudEvents: https://github.com/cloudevents/spec/blob/v0.1/spec.md
 *
 * @author linux_china
 */
public class DomainEvent<T extends Serializable> {
    /**
     * cloud events version
     */
    @JsonProperty("cloudEventsVersion")
    private String cloudEventsVersion = "0.1";
    /**
     * event ID
     */
    @JsonProperty("eventID")
    private String eventID = UUID.randomUUID().toString();
    /**
     * event type: com.example.someevent
     */
    @JsonProperty("eventType")
    private String eventType;
    /**
     * event type version:
     */
    @JsonProperty("eventTypeVersion")
    private String eventTypeVersion;
    /**
     * additional metadata
     */
    @JsonProperty("extensions")
    private Map<String, Serializable> extensions;
    /**
     * event producer
     */
    @JsonProperty("source")
    private URI source;
    /**
     * content type for data, such as text/plain, application/json
     */
    @JsonProperty("contentType")
    private String contentType;
    /**
     * The event payload
     */
    @JsonProperty("data")
    private T data;
    /**
     * A link to the schema that the data attribute adheres to
     */
    @JsonProperty("schemaURL")
    private URI schemaURL;
    /**
     * Timestamp of when the event happened
     */
    @JsonProperty("eventTime")
    private Date eventTime;

    public DomainEvent() {
        this.eventTime = new Date();
    }

    public DomainEvent(T data) {
        this.data = data;
        this.eventTime = new Date();
    }

    public DomainEvent(String type, T data) {
        this.contentType = type;
        this.data = data;
        this.eventTime = new Date();
    }

    public DomainEvent(String type, T data, URI source) {
        this.contentType = type;
        this.data = data;
        this.source = source;
        this.eventTime = new Date();
    }

    public String getCloudEventsVersion() {
        return cloudEventsVersion;
    }

    public void setCloudEventsVersion(String cloudEventsVersion) {
        this.cloudEventsVersion = cloudEventsVersion;
    }

    public String getEventID() {
        return eventID;
    }

    public void setEventID(String eventID) {
        this.eventID = eventID;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventTypeVersion() {
        return eventTypeVersion;
    }

    public void setEventTypeVersion(String eventTypeVersion) {
        this.eventTypeVersion = eventTypeVersion;
    }

    public Map<String, Serializable> getExtensions() {
        return extensions;
    }

    public void setExtensions(Map<String, Serializable> extensions) {
        this.extensions = extensions;
    }

    public URI getSource() {
        return source;
    }

    public void setSource(URI source) {
        this.source = source;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public URI getSchemaURL() {
        return schemaURL;
    }

    public void setSchemaURL(URI schemaURL) {
        this.schemaURL = schemaURL;
    }

    public Date getEventTime() {
        return eventTime;
    }

    public void setEventTime(Date eventTime) {
        this.eventTime = eventTime;
    }

    public Serializable getExtension(String name) {
        return extensions == null ? null : extensions.get(name);
    }

    public void setExtension(String name, Serializable value) {
        if (extensions == null) {
            extensions = new HashMap<>();
        }
        this.extensions.put(name, value);
    }
}
