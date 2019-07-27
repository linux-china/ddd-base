package org.mvnsearch.ddd.domain.events;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Cloud Event Handler
 *
 * @author linux_china
 */
@Target(value = {METHOD, ANNOTATION_TYPE})
@Retention(value = RUNTIME)
@Documented
public @interface CloudEventHandler {
    String type();

    String source();

    String subject();

    String[] extensions();
}
