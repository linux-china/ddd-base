package org.mvnsearch.ddd.domain;

import org.mvnsearch.ddd.domain.annotations.DomainEntity;

/**
 * base domain entity
 *
 * @author linux_china
 */
@DomainEntity
public interface BaseDomainEntity<ID> extends BaseModel {
    /**
     * get entity id
     *
     * @return entity id
     */
    public ID getId();
}
