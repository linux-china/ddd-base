package org.mvnsearch.ddd.domain.events.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.PropertyWriter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import org.mvnsearch.ddd.domain.events.DomainEvent;

import java.util.Base64;

/**
 * Domain Event data field filter: change data to data_base64 when data's type is byte[]
 *
 * @author linux_china
 */
public class DomainEventDataFieldFilter extends SimpleBeanPropertyFilter {

    @Override
    protected boolean include(BeanPropertyWriter writer) {
        return super.include(writer);
    }

    @Override
    protected boolean include(PropertyWriter writer) {
        return super.include(writer);
    }

    public void serializeAsField(Object pojo, JsonGenerator gen, SerializerProvider prov,
                                 PropertyWriter writer)
            throws Exception {
        if (pojo instanceof DomainEvent && writer.getName().equals("data")) {
            Object data = ((DomainEvent) pojo).getData();
            if (data instanceof byte[]) {
                gen.writeStringField("data_base64", Base64.getEncoder().encodeToString((byte[]) data));
                return;
            }
        }
        super.serializeAsField(pojo, gen, prov, writer);
    }
}
