package org.mvnsearch.ddd.domain.events;

import java.net.URI;
import java.time.ZonedDateTime;
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
        builder.data(data);
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


    public DomainEventBuilder<T> dataContentType(String contentType) {
        domainEvent.setDataContentType(contentType);
        return this;
    }

    public DomainEventBuilder<T> data(T data) {
        domainEvent.setData(data);
        return this;
    }

    public DomainEventBuilder<T> dataSchema(URI schemaURL) {
        domainEvent.setDataSchema(schemaURL);
        return this;
    }

    public DomainEventBuilder<T> time(ZonedDateTime eventTime) {
        domainEvent.setTime(eventTime);
        return this;
    }

    public DomainEventBuilder<T> extensions(Map<String, Object> extensions) {
        domainEvent.setExtensions(extensions);
        return this;
    }

    public DomainEventBuilder<T> extension(String name, Object value) {
        domainEvent.setExtension(name, value);
        return this;
    }

    public DomainEventBuilder<T> dataref(URI dataref) {
        domainEvent.setExtension(ExtensionAttribute.DATA_REF.getKey(), dataref);
        return this;
    }

    public DomainEventBuilder<T> traceparent(String traceparent) {
        domainEvent.setExtension(ExtensionAttribute.TRACE_PARENT.getKey(), traceparent);
        return this;
    }

    public DomainEventBuilder<T> tracestate(String tracestate) {
        domainEvent.setExtension(ExtensionAttribute.TRACE_STATE.getKey(), tracestate);
        return this;
    }

    public DomainEventBuilder<T> totraceid(String totraceid) {
        domainEvent.setExtension(ExtensionAttribute.TO_TRACE_ID.getKey(), totraceid);
        return this;
    }

    public DomainEventBuilder<T> toppanid(String toSpanId) {
        domainEvent.setExtension(ExtensionAttribute.TO_SPAN_ID.getKey(), toSpanId);
        return this;
    }

    public DomainEventBuilder<T> partitionkey(String partitionkey) {
        domainEvent.setExtension(ExtensionAttribute.PARTITION_KEY.getKey(), partitionkey);
        return this;
    }

    public DomainEventBuilder<T> sampledrate(Integer sampledrate) {
        domainEvent.setExtension(ExtensionAttribute.SAMPLED_RATE.getKey(), sampledrate);
        return this;
    }

    public DomainEventBuilder<T> sequence(String sequence) {
        domainEvent.setExtension(ExtensionAttribute.SEQUENCE.getKey(), sequence);
        return this;
    }

    public DomainEventBuilder<T> tenantid(String tenantId) {
        domainEvent.setExtension(ExtensionAttribute.TENANT_ID.getKey(), tenantId);
        return this;
    }

    public DomainEventBuilder<T> signature(String signature) {
        domainEvent.setExtension(ExtensionAttribute.SIGNATURE.getKey(), signature);
        return this;
    }

    public DomainEventBuilder<T> routing(String routing) {
        domainEvent.setExtension(ExtensionAttribute.ROUTING.getKey(), routing);
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
