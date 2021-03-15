package org.mvnsearch.ddd.application.annotations;

import java.lang.annotation.*;

/**
 * ApplicationLayer for package-info.java
 *
 * @author linux_china
 */
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.PACKAGE, ElementType.TYPE})
@Documented
public @interface ApplicationLayer {
}