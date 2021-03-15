package org.mvnsearch.ddd.domain.annotations;

import java.lang.annotation.*;

/**
 * DomainLayer for package-info.java
 *
 * @author linux_china
 */
@Retention(RetentionPolicy.CLASS)
@Target({ ElementType.PACKAGE, ElementType.TYPE })
@Documented
public @interface DomainLayer {
}