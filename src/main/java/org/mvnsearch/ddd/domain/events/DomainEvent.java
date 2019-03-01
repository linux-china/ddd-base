package org.mvnsearch.ddd.domain.events;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties(value = {"$schema"})
public class DomainEvent<T> {
    /**
     * cloud events version
     */
    @JsonProperty("specversion")
    private String specversion = "0.2";
    /**
     * event ID
     */
    @JsonProperty("id")
    private String id = UUID.randomUUID().toString();
    /**
     * event type: com.example.someevent
     */
    @JsonProperty("type")
    private String type;
    /**
     * additional metadata
     */
    @JsonProperty("extensions")
    private Map<String, String> extensions;
    /**
     * event producer
     */
    @JsonProperty("source")
    private URI source;
    /**
     * content type for data, such as text/plain, application/json
     */
    @JsonProperty("datacontenttype")
    private String datacontenttype;
    /**
     * The event payload
     */
    @JsonProperty("data")
    private T data;
    /**
     * A link to the schema that the data attribute adheres to
     */
    @JsonProperty("schemaurl")
    private URI schemaURL;
    /**
     * Timestamp of when the event happened
     */
    @JsonProperty("time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ")
    private Date time;

    public DomainEvent() {
        this.time = new Date();
    }

    public DomainEvent(T data) {
        this.data = data;
        this.time = new Date();
    }

    public DomainEvent(String type, T data) {
        this.datacontenttype = type;
        this.data = data;
        this.time = new Date();
    }

    public DomainEvent(String type, T data, URI source) {
        this.datacontenttype = type;
        this.data = data;
        this.source = source;
        this.time = new Date();
    }

    public String getSpecversion() {
        return specversion;
    }

    public void setSpecversion(String specversion) {
        this.specversion = specversion;
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

    public Map<String, String> getExtensions() {
        return extensions;
    }

    public void setExtensions(Map<String, String> extensions) {
        this.extensions = extensions;
    }

    public URI getSource() {
        return source;
    }

    public void setSource(URI source) {
        this.source = source;
    }

    public String getDatacontenttype() {
        return datacontenttype;
    }

    public void setDatacontenttype(String datacontenttype) {
        this.datacontenttype = datacontenttype;
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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Serializable getExtension(String name) {
        return extensions == null ? null : extensions.get(name);
    }

    public void setExtension(String name, String value) {
        if (extensions == null) {
            extensions = new HashMap<>();
        }
        this.extensions.put(name, value);
    }
}
