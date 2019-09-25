package org.mvnsearch.ddd.domain.events;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.URI;

/**
 * Domain Event test
 *
 * @author linux_china
 */
public class DomainEventTest {

    @Test
    public void testEncodeDecode() {
        DomainEvent<String> event = DomainEventBuilder.<String>newInstance()
                .id("xxx")
                .contentType("text/plain")
                .data("1234")
                .source(URI.create("demo"))
                .type("demo")
                .sequence("1234")
                .build();
        String jsonText = Json.encode(event);
        System.out.println(jsonText);
        DomainEvent event2 = Json.decodeValue(jsonText, DomainEvent.class);
        Assertions.assertEquals(event2.getExtension("sequence"), "1234");
    }

    @Test
    public void testBinaryEvent() {
        DomainEvent<byte[]> event = DomainEventBuilder.<byte[]>newInstance()
                .id("xxx")
                .contentType("text/plain")
                .data("good".getBytes())
                .source(URI.create("demo"))
                .type("demo")
                .sequence("11234")
                .build();
        String jsonText = Json.encode(event);
        Assertions.assertFalse(jsonText.contains("\"data\":"));
        Assertions.assertTrue(jsonText.contains("\"data_base64\":"));
    }
}
