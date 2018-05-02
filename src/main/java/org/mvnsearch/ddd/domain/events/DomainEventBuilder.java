package org.mvnsearch.ddd.domain.events;

import java.io.Serializable;
import java.net.URI;
import java.util.Date;
import java.util.Map;

/**
 * domain event builder
 *
 * @author linux_china
 */
public class DomainEventBuilder<T extends Serializable> {
    /**
     * cloud event
     */
    private DomainEvent<T> domainEvent;

    public static <K extends Serializable> DomainEventBuilder<K> newInstance() {
        DomainEventBuilder<K> builder = new DomainEventBuilder<K>();
        builder.domainEvent = new DomainEvent<K>();
        return builder;
    }

    public DomainEventBuilder<T> eventID(String eventId) {
        domainEvent.setEventID(eventId);
        return this;
    }

    public DomainEventBuilder<T> eventType(String eventType) {
        domainEvent.setEventType(eventType);
        return this;
    }

    public DomainEventBuilder<T> eventTypeVersion(String eventTypeVersion) {
        domainEvent.setEventTypeVersion(eventTypeVersion);
        return this;
    }


    public DomainEventBuilder<T> source(URI source) {
        domainEvent.setSource(source);
        return this;
    }


    public DomainEventBuilder<T> contentType(String contentType) {
        domainEvent.setContentType(contentType);
        return this;
    }

    public DomainEventBuilder<T> data(T data) {
        domainEvent.setData(data);
        return this;
    }

    public DomainEventBuilder<T> schemaURL(URI schemaURL) {
        domainEvent.setSchemaURL(schemaURL);
        return this;
    }

    public DomainEventBuilder<T> eventTime(Date eventTime) {
        domainEvent.setEventTime(eventTime);
        return this;
    }

    public DomainEventBuilder<T> extensions(Map<String, String> extensions) {
        domainEvent.setExtensions(extensions);
        return this;
    }

    public DomainEventBuilder<T> extension(String name, String value) {
        domainEvent.setExtension(name, value);
        return this;
    }

    public DomainEventBuilder<T> cloudEventsVersion(String cloudEventsVersion) {
        domainEvent.setCloudEventsVersion(cloudEventsVersion);
        return this;
    }

    public DomainEvent<T> build() {
        return domainEvent;
    }

}
