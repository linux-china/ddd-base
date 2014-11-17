package org.mvnsearch.ddd.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * base entity
 *
 * @author linux_china
 */
public interface BaseEntity<T extends Serializable> {
    /**
     * get entity id
     *
     * @return entity id
     */
    public T getId();

    /**
     * get created timestamp
     *
     * @return created timestamp
     */
    public Date getCreatedAt();

    /**
     * set created timestamp
     *
     * @param createdAt created timestamp
     */
    public void setCreatedAt(Date createdAt);

    /**
     * get last updated timestamp
     *
     * @return last updated timestamp
     */
    public Date getUpdatedAt();

    /**
     * set updated timestamp
     *
     * @param updatedAt updated timestamp
     */
    public void setUpdatedAt(Date updatedAt);

    /**
     * get entity status
     *
     * @return entity status
     */
    public Integer getStatus();
}
