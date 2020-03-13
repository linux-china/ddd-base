package org.mvnsearch.ddd.domain.events.jackson;

import com.fasterxml.jackson.databind.module.SimpleModule;

import java.time.ZonedDateTime;

/**
 * Jackson CloudEvents Module
 *
 * @author linux_china
 */
public class CloudEventsModule extends SimpleModule {
    public CloudEventsModule() {
        this.addSerializer(ZonedDateTime.class, new ZonedDateTimeSerializer());
        this.addDeserializer(ZonedDateTime.class, new ZonedDateTimeDeserializer());
    }
}
