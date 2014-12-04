package org.mvnsearch.ddd.management.status;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * Carries information about the health of a component or subsystem.
 * <pre class="code">
 * try {
 * // do some test to determine state of component
 * return new Health.Builder().up().withDetail(&quot;version&quot;, &quot;1.1.2&quot;).build();
 * }
 * catch (Exception ex) {
 * return new Health.Builder().down(ex).build();
 * }
 * </pre>
 *
 * @author Christian Dupuis
 * @author Phillip Webb
 * @author linux_china
 */
public final class Health {

    private final Status status;

    private final Map<String, Object> details;

    /**
     * Create a new {@link Health} instance with the specified status and details.
     *
     * @param builder the Builder to use
     */
    private Health(Builder builder) {
        this.status = builder.status;
        this.details = Collections.unmodifiableMap(builder.details);
    }

    /**
     * @return the status of the health (never {@code null})
     */
    public Status getStatus() {
        return this.status;
    }

    /**
     * @return the details of the health or an empty map.
     */
    public Map<String, Object> getDetails() {
        return this.details;
    }

    @Override
    public String toString() {
        return getStatus() + " " + getDetails();
    }

    /**
     * Create a new {@link Builder} instance with an {@link Status#UNKNOWN} status.
     *
     * @return a new {@link Builder} instance
     */
    public static Builder unknown() {
        return status(Status.UNKNOWN);
    }

    /**
     * Create a new {@link Builder} instance with an {@link Status#UP} status.
     *
     * @return a new {@link Builder} instance
     */
    public static Builder up() {
        return status(Status.UP);
    }

    /**
     * Create a new {@link Builder} instance with an {@link Status#DOWN} status an the
     * specified exception details.
     *
     * @param ex the exception
     * @return a new {@link Builder} instance
     */
    public static Builder down(Exception ex) {
        return down().withException(ex);
    }

    /**
     * Create a new {@link Builder} instance with a {@link Status#DOWN} status.
     *
     * @return a new {@link Builder} instance
     */
    public static Builder down() {
        return status(Status.DOWN);
    }

    /**
     * Create a new {@link Builder} instance with an {@link Status#OUT_OF_SERVICE} status.
     *
     * @return a new {@link Builder} instance
     */
    public static Builder outOfService() {
        return status(Status.OUT_OF_SERVICE);
    }

    /**
     * Create a new {@link Builder} instance with a specific status code.
     *
     * @return a new {@link Builder} instance
     */
    public static Builder status(String statusCode) {
        return status(new Status(statusCode));
    }

    /**
     * Create a new {@link Builder} instance with a specific {@link Status}.
     *
     * @return a new {@link Builder} instance
     */
    public static Builder status(Status status) {
        return new Builder(status);
    }

    /**
     * Builder for creating immutable {@link Health} instances.
     */
    public static class Builder {

        private Status status;

        private Map<String, Object> details;

        /**
         * Create new Builder instance.
         */
        public Builder() {
            this.status = Status.UNKNOWN;
            this.details = new LinkedHashMap<String, Object>();
        }

        /**
         * Create new Builder instance, setting status to given <code>status</code>.
         *
         * @param status the {@link Status} to use
         */
        public Builder(Status status) {
            this.status = status;
            this.details = new LinkedHashMap<String, Object>();
        }

        /**
         * Create new Builder instance, setting status to given <code>status</code> and
         * details to given <code>details</code>.
         *
         * @param status  the {@link Status} to use
         * @param details the details {@link Map} to use
         */
        public Builder(Status status, Map<String, ?> details) {
            this.status = status;
            this.details = new LinkedHashMap<String, Object>(details);
        }

        /**
         * Record detail for given {@link Exception}.
         *
         * @param ex the exception
         * @return this {@link Builder} instance
         */
        public Builder withException(Exception ex) {
            return withDetail("error", ex.getClass().getName() + ": " + ex.getMessage());
        }

        /**
         * Record detail using <code>key</code> and <code>value</code>.
         *
         * @param key  the detail key
         * @param data the detail data
         * @return this {@link Builder} instance
         */
        public Builder withDetail(String key, Object data) {
            this.details.put(key, data);
            return this;
        }

        /**
         * Set status to {@link Status#UNKNOWN} status.
         *
         * @return this {@link Builder} instance
         */
        public Builder unknown() {
            return status(Status.UNKNOWN);
        }

        /**
         * Set status to {@link Status#UP} status.
         *
         * @return this {@link Builder} instance
         */
        public Builder up() {
            return status(Status.UP);
        }

        /**
         * Set status to {@link Status#DOWN} and add details for given {@link Exception}.
         *
         * @param ex the exception
         * @return this {@link Builder} instance
         */
        public Builder down(Exception ex) {
            return down().withException(ex);
        }

        /**
         * Set status to {@link Status#DOWN}.
         *
         * @return this {@link Builder} instance
         */
        public Builder down() {
            return status(Status.DOWN);
        }

        /**
         * Set status to {@link Status#OUT_OF_SERVICE}.
         *
         * @return this {@link Builder} instance
         */
        public Builder outOfService() {
            return status(Status.OUT_OF_SERVICE);
        }

        /**
         * Set status to given <code>statusCode</code>.
         *
         * @return this {@link Builder} instance
         */
        public Builder status(String statusCode) {
            return status(new Status(statusCode));
        }

        /**
         * Set status to given {@link Status} instance
         *
         * @param status status
         * @return this {@link Builder} instance
         */
        public Builder status(Status status) {
            this.status = status;
            return this;
        }

        /**
         * Create a new {@link Health} instance with the previously specified code and
         * details.
         *
         * @return a new {@link Health} instance
         */
        public Health build() {
            return new Health(this);
        }
    }

}