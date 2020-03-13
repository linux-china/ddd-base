package org.mvnsearch.ddd.domain.events;

/**
 * CloudEvent Extension Attribute enum
 *
 * @author linux_china
 */
public enum ExtensionAttribute {
    /**
     * A reference to a location where the event payload is stored
     * https://github.com/cloudevents/spec/blob/master/extensions/dataref.md
     */
    DATA_REF("dataref"),
    /**
     * Contains a version, trace ID, span ID, and trace options
     * https://github.com/cloudevents/spec/blob/master/extensions/distributed-tracing.md
     */
    TRACE_PARENT("traceparent"),
    /**
     * a comma-delimited list of key-value pairs
     * https://github.com/cloudevents/spec/blob/master/extensions/distributed-tracing.md
     */
    TRACE_STATE("tracestate"),
    /**
     * Globally unique trace id
     * https://github.com/opentracing/specification/blob/master/rfc/trace_identifiers.md
     */
    TO_TRACE_ID("totraceid"),
    /**
     * Unique within a trace
     * https://github.com/opentracing/specification/blob/master/rfc/trace_identifiers.md
     */
    TO_SPAN_ID("tospanid"),
    /**
     * partition key for the event, typically for the purposes of defining a causal relationship/grouping between multiple events
     * https://github.com/cloudevents/spec/blob/master/extensions/partitioning.md
     */
    PARTITION_KEY("partitionkey"),
    /**
     * The rate at which this event has already been sampled
     * https://github.com/cloudevents/spec/blob/master/extensions/sampled-rate.md
     */
    SAMPLED_RATE("sampledrate"),
    /**
     * Value expressing the relative order of the event
     * https://github.com/cloudevents/spec/blob/master/extensions/sequence.md
     */
    SEQUENCE("sequence"),
    /**
     * Specifies the semantics of the sequence attribute
     * https://github.com/cloudevents/spec/blob/master/extensions/sequence.md
     */
    SEQUENCE_TYPE("sequencetype"),
    /**
     * tenant id
     */
    TENANT_ID("tenantid"),
    /**
     * event rouging
     */
    ROUTING("routing"),
    /**
     * event signature, please refer DKIM format
     */
    SIGNATURE("signature");

    private final String key;

    ExtensionAttribute(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
