package org.mvnsearch.ddd.infrastructure.metric;

import java.util.Date;

/**
 * Immutable class that can be used to hold any arbitrary system measurement value (a
 * named numeric value with a timestamp). For example a metric might record the number of
 * active connections to a server, or the temperature of a meeting room.
 *
 * @author Dave Syer
 */
public class Metric<T extends Number> {

    private final String name;

    private final T value;

    private final Date timestamp;

    /**
     * Create a new {@link Metric} instance for the current time.
     *
     * @param name  the name of the metric
     * @param value the value of the metric
     */
    public Metric(String name, T value) {
        this(name, value, new Date());
    }

    /**
     * Create a new {@link Metric} instance.
     *
     * @param name      the name of the metric
     * @param value     the value of the metric
     * @param timestamp the timestamp for the metric
     */
    public Metric(String name, T value, Date timestamp) {
        this.name = name;
        this.value = value;
        this.timestamp = timestamp;
    }

    /**
     * Returns the name of the metric.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the value of the metric.
     */
    public T getValue() {
        return this.value;
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    @Override
    public String toString() {
        return "Metric [name=" + this.name + ", value=" + this.value + ", timestamp=" + this.timestamp + "]";
    }

    /**
     * Create a new {@link Metric} with an incremented value.
     *
     * @param amount the amount that the new metric will differ from this one
     * @return a new {@link Metric} instance
     */
    public Metric<Long> increment(int amount) {
        return new Metric<Long>(this.getName(), this.getValue().longValue() + amount);
    }

    /**
     * Create a new {@link Metric} with a different value.
     *
     * @param value the value of the new metric
     * @return a new {@link Metric} instance
     */
    public <S extends Number> Metric<S> set(S value) {
        return new Metric<S>(this.getName(), value);
    }

}