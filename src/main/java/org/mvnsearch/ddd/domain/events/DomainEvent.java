package org.mvnsearch.ddd.domain.events;

import com.fasterxml.jackson.annotation.*;

import java.net.URI;
import java.util.*;

/**
 * domain event from CloudEvents: https://github.com/cloudevents/spec/blob/v0.1/spec.md
 *
 * @author linux_china
 */
@JsonIgnoreProperties(value = {"$schema"})
public class DomainEvent<T> {
    /**
     * cloud events spec version
     */
    @JsonProperty("specversion")
    private String specVersion = "0.3";
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
    private Map<String, Object> extensions;
    /**
     * event producer
     */
    @JsonProperty("source")
    private URI source;
    /**
     * indicates which resource the event is about
     */
    private String subject;
    /**
     * content type for data, such as text/plain, application/json
     */
    @JsonProperty("datacontenttype")
    private String dataContentType;
    /**
     * The event payload
     */
    @JsonProperty("data")
    private T data;
    @JsonProperty("data_base64")
    private String dataBase64;
    /**
     * A link to the schema that the data attribute adheres to
     */
    @JsonProperty("schemaurl")
    private URI schemaURL;
    /**
     * Timestamp of when the event happened
     */
    @JsonProperty("time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssX")
    private Date time;

    public DomainEvent() {
        this.time = new Date();
    }

    public DomainEvent(T data) {
        this.data = data;
        this.time = new Date();
    }

    public DomainEvent(String type, T data) {
        this.dataContentType = type;
        this.data = data;
        this.time = new Date();
    }

    public DomainEvent(String type, T data, URI source) {
        this.dataContentType = type;
        this.data = data;
        this.source = source;
        this.time = new Date();
    }

    public String getSpecVersion() {
        return specVersion;
    }

    public void setSpecVersion(String specVersion) {
        this.specVersion = specVersion;
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

    public URI getSource() {
        return source;
    }

    public void setSource(URI source) {
        this.source = source;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDataContentType() {
        return dataContentType;
    }

    public void setDataContentType(String dataContentType) {
        this.dataContentType = dataContentType;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        if (data instanceof byte[]) {
            setDataBytes((byte[]) data);
        }
        this.data = data;
    }

    public void setDataBytes(byte[] data) {
        this.dataBase64 = Base64.getEncoder().encodeToString(data);
    }

    public String getDataBase64() {
        return dataBase64;
    }

    public void setDataBase64(String dataBase64) {
        this.dataBase64 = dataBase64;
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

    @JsonAnyGetter
    public Map<String, Object> getExtensions() {
        return extensions;
    }

    public void setExtensions(Map<String, Object> extensions) {
        this.extensions = extensions;
    }

    public Object getExtension(String name) {
        return extensions == null ? null : extensions.get(name);
    }

    @JsonAnySetter
    public void setExtension(String name, Object value) {
        if (extensions == null) {
            extensions = new HashMap<>();
        }
        this.extensions.put(name, value);
    }
}
