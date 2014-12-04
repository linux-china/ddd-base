package org.mvnsearch.ddd.management.state;

/**
 * service state indicator
 *
 * @author linux_china
 */
public interface StateIndicator {
    /**
     * get current state
     *
     * @return state
     */
    public State state();
}
