package org.mvnsearch.ddd.domain.events;

import java.net.URI;
import java.util.Date;
import java.util.Map;

/**
 * domain event builder
 *
 * @author linux_china
 */
public class DomainEventBuilder<T> {
    /**
     * domain event
     */
    private DomainEvent<T> domainEvent;

    public static <K> DomainEventBuilder<K> newInstance() {
        DomainEventBuilder<K> builder = new DomainEventBuilder<K>();
        builder.domainEvent = new DomainEvent<K>();
        return builder;
    }

    public static DomainEventBuilder<Map<String, Object>> newInstance(Map<String, Object> data) {
        DomainEventBuilder<Map<String, Object>> builder = new DomainEventBuilder<Map<String, Object>>();
        builder.domainEvent = new MapDomainEvent();
        builder.domainEvent.setDataContentType("application/json");
        return builder;
    }

    public DomainEventBuilder<T> id(String eventId) {
        domainEvent.setId(eventId);
        return this;
    }

    public DomainEventBuilder<T> type(String eventType) {
        domainEvent.setType(eventType);
        return this;
    }

    public DomainEventBuilder<T> source(URI source) {
        domainEvent.setSource(source);
        return this;
    }


    public DomainEventBuilder<T> contentType(String contentType) {
        domainEvent.setDataContentType(contentType);
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

    public DomainEventBuilder<T> time(Date eventTime) {
        domainEvent.setTime(eventTime);
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

    public DomainEventBuilder<T> spec(String specVersion) {
        domainEvent.setSpecVersion(specVersion);
        return this;
    }

    public DomainEvent<T> build() {
        return domainEvent;
    }

}
