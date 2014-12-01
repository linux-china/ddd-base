package org.mvnsearch.ddd.infrastructure;

/**
 * Strategy interface used to provide an indication of service health.
 *
 * @author Dave Syer
 * @author linux_china
 */
public interface HealthIndicator {

    /**
     * @return an indication of health
     */
    Health health();

}