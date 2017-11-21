package org.mvnsearch.ddd.domain.events;

import java.util.HashMap;
import java.util.Map;

/**
 * event message
 *
 * @author linux_china
 */
public class EventMessage {
    private String path;
    private Map<String, String> headers;
    private byte[] body;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public byte[] getBody() {
        return body;
    }

    public void setBody(byte[] body) {
        this.body = body;
    }

    public String getHeader(String name) {
        return headers == null ? null : headers.get(name);
    }

    public void setHeader(String name, String value) {
        if (headers == null) {
            headers = new HashMap<>();
        }
        this.headers.put(name, value);
    }
}
