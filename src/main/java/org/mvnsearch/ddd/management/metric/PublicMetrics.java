package org.mvnsearch.ddd.management.metric;

import java.util.Collection;

/**
 * Interface to expose specific {@link Metric}s
 *
 * @author Dave Syer
 */
public interface PublicMetrics {

    /**
     * @return an indication of current state through metrics
     */
    Collection<Metric<?>> metrics();

}