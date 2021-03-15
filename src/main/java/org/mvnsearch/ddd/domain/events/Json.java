/**
 * Copyright 2018 The CloudEvents Authors
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.mvnsearch.ddd.domain.events;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.mvnsearch.ddd.domain.events.jackson.DomainEventDataFieldFilter;

import java.io.InputStream;

public final class Json {
    /**
     * Domain Event data field filter
     */
    private static FilterProvider domainEventDataFieldFilter = new SimpleFilterProvider().addFilter("DomainEventDataFieldFilter", new DomainEventDataFieldFilter());

    public static final ObjectMapper MAPPER = new ObjectMapper();

    static {
        MAPPER.findAndRegisterModules();
        MAPPER.setSerializationInclusion(JsonInclude.Include.NON_ABSENT);
    }

    /**
     * Encode a POJO to JSON using the underlying Jackson mapper.
     *
     * @param event domain event
     * @return a String containing the JSON representation of the given POJO.
     * @throws IllegalStateException if a property cannot be encoded.
     */
    @SuppressWarnings("unchecked")
    public static String encode(final DomainEvent event) throws IllegalStateException {
        try {
            return MAPPER.writer(domainEventDataFieldFilter).writeValueAsString(event);
        } catch (Exception e) {
            throw new IllegalStateException("Failed to encode as JSON: " + e.getMessage());
        }
    }

    public static DomainEvent fromInputStream(final InputStream inputStream) {
        try {
            return MAPPER.readValue(inputStream, DomainEvent.class);
        } catch (Exception e) {
            throw new IllegalStateException("Failed to encode as JSON: " + e.getMessage());
        }
    }

    /**
     * Decode a given JSON string to a CloudEvent .
     *
     * @param str the JSON string.
     * @return an instance of CloudEvent
     * @throws IllegalStateException when there is a parsing or invalid mapping.
     */
    public static DomainEvent decodeDomainEvent(final String str) throws IllegalStateException {
        return decodeValue(str, DomainEvent.class);
    }

    /**
     * Decode a given JSON string to a POJO of the given class type.
     *
     * @param str   the JSON string.
     * @param clazz the class to map to.
     * @param <T>   the generic type.
     * @return an instance of T
     * @throws IllegalStateException when there is a parsing or invalid mapping.
     */
    protected static <T> T decodeValue(final String str, final Class<T> clazz) throws IllegalStateException {
        try {
            return MAPPER.readValue(str, clazz);
        } catch (Exception e) {
            throw new IllegalStateException("Failed to decode: " + e.getMessage());
        }
    }


    public static byte[] encodePOJOAsBytes(final Object pojo) throws IllegalStateException {
        try {
            return MAPPER.writeValueAsBytes(pojo);
        } catch (Exception e) {
            throw new IllegalStateException("Failed to encode as JSON: " + e.getMessage());
        }
    }

    public static <T> T decodePOJO(final byte[] bytes, Class<T> clazz) throws IllegalStateException {
        try {
            return MAPPER.readValue(bytes, clazz);
        } catch (Exception e) {
            throw new IllegalStateException("Failed to encode as JSON: " + e.getMessage());
        }
    }

    /**
     * Decode a given JSON string to a POJO of the given type.
     *
     * @param str  the JSON string.
     * @param type the type to map to.
     * @param <T>  the generic type.
     * @return an instance of T
     * @throws IllegalStateException when there is a parsing or invalid mapping.
     */
    public static <T> T decodeValue(final String str, final TypeReference<T> type) throws IllegalStateException {
        try {
            return MAPPER.readValue(str, type);
        } catch (Exception e) {
            throw new IllegalStateException("Failed to decode: " + e.getMessage(), e);
        }
    }

    private Json() {
        // no-op
    }
}
