package org.mvnsearch.ddd.domain;

import org.mvnsearch.ddd.domain.annotations.DomainAggregate;

import java.io.Serializable;

/**
 * base domain aggregate
 *
 * @author linux_china
 */
@DomainAggregate
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
