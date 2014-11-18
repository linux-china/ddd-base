package org.mvnsearch.ddd.domain;

import java.io.Serializable;

/**
 * base domain aggregate
 *
 * @author linux_china
 */
public abstract class BaseDomainAggregate<K extends Serializable> implements BaseEntity<K> {
    /**
     * get aggregate root
     *
     * @return root object
     */
    public abstract K getRoot();

    public K getId() {
        return getRoot();
    }
}
