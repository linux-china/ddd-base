package org.mvnsearch.ddd.domain.events;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.mvnsearch.ddd.domain.events.jackson.BytesDataSerializer;

import java.net.URI;
import java.time.ZonedDateTime;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * domain event from CloudEvents: https://github.com/cloudevents/spec/blob/v1.0-rc1/spec.md
 *
 * @author linux_china
 */
@JsonIgnoreProperties(value = {"$schema"})
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("dataBase64Filter")
public class DomainEvent<T> {
    /**
     * cloud events spec version
     */
    @JsonProperty("specversion")
    private String specVersion = "1.0";
    /**
     * event ID
     */
    @JsonProperty("id")
    private String id = UUID.randomUUID().toString();
    /**
     * event type: com.example.SomeEvent
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
    /**
     * A link to the schema that the data attribute adheres to
     */
    @JsonProperty("dataschema")
    private URI dataSchema;
    /**
     * Timestamp of when the event happened
     */
    @JsonProperty("time")
    private ZonedDateTime time;

    public DomainEvent() {
        this.time = ZonedDateTime.now();
    }

    public DomainEvent(T data) {
        this.data = data;
        this.time = ZonedDateTime.now();
    }

    public DomainEvent(String type, T data) {
        this.dataContentType = type;
        this.data = data;
        this.time = ZonedDateTime.now();
    }

    public DomainEvent(String type, T data, URI source) {
        this.dataContentType = type;
        this.data = data;
        this.source = source;
        this.time = ZonedDateTime.now();
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
        this.data = data;
    }

    @JsonProperty("data_base64")
    public String getDataBase64() {
        if (data != null && data instanceof byte[]) {
            return Base64.getEncoder().encodeToString((byte[]) data);
        }
        return null;
    }

    @JsonAlias({"data_base64"})
    public void setDataBase64(String dataBase64) {
        this.data = (T) Base64.getDecoder().decode(dataBase64);
    }


    public URI getDataSchema() {
        return dataSchema;
    }

    public void setDataSchema(URI dataSchema) {
        this.dataSchema = dataSchema;
    }

    public ZonedDateTime getTime() {
        return time;
    }

    public void setTime(ZonedDateTime time) {
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
