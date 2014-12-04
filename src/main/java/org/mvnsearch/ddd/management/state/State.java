package org.mvnsearch.ddd.management.state;

/**
 * service state
 *
 * @author linux_china
 */
public enum State {
    NEW,
    RUNNABLE,
    RUNNING,
    TIMED_WAITING,
    WAITING,
    PAUSED,
    BLOCKED,
    TERMINATED
}
