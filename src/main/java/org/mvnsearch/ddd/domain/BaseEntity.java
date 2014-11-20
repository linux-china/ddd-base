package org.mvnsearch.ddd.domain;

import java.io.Serializable;

/**
 * base entity for domain entity and aggregate
 *
 * @author linux_china
 */
public interface BaseEntity<K extends Serializable> extends Serializable{
    /**
     * get entity id
     *
     * @return entity id
     */
    public K getId();

}
