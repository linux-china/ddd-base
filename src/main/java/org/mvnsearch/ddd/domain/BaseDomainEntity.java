package org.mvnsearch.ddd.domain;

import org.mvnsearch.ddd.domain.annotations.DomainEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * base domain entity
 *
 * @author linux_china
 */
@DomainEntity
public interface BaseDomainEntity<K extends Serializable> extends BaseEntity<K> {

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
