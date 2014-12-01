package org.mvnsearch.ddd.infrastructure.status;

/**
 * Value object to express state of a service
 *
 * @author Christian Dupuis
 * @author linux_china
 */
public final class Status {

    /**
     * Convenient constant value representing unknown state
     */
    public static final Status UNKNOWN = new Status("UNKNOWN");

    /**
     * Convenient constant value representing up state
     */
    public static final Status UP = new Status("UP");

    /**
     * Convenient constant value representing down state
     */
    public static final Status DOWN = new Status("DOWN");

    /**
     * Convenient constant value representing out-of-service state
     */
    public static final Status OUT_OF_SERVICE = new Status("OUT_OF_SERVICE");

    private final String code;

    private final String description;

    public Status(String code) {
        this(code, "");
    }

    /**
     * Create a new {@link Status} instance with the given code and description.
     *
     * @param code        the status code
     * @param description a description of the status
     */
    public Status(String code, String description) {
        this.code = code;
        this.description = description;
    }

    /**
     * @return the code for this status
     */
    public String getCode() {
        return this.code;
    }

    /**
     * @return the description of this status
     */
    public String getDescription() {
        return this.description;
    }

    @Override
    public String toString() {
        return this.code;
    }

    @Override
    public int hashCode() {
        return this.code.hashCode();
    }
}
