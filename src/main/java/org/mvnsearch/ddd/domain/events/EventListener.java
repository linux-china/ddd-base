package org.mvnsearch.ddd.domain.events;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * event listener annotation
 *
 * @author linux_china
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface EventListener {

    boolean asynchronous() default false;

}
