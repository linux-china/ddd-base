package org.mvnsearch.ddd.infrastructure.annotations;

import java.lang.annotation.*;

/**
 * InfrastructureLayer for package-info.java
 *
 * @author linux_china
 */
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.PACKAGE, ElementType.TYPE})
@Documented
public @interface InfrastructureLayer {
}
