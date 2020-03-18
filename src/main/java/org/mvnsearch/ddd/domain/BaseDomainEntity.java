package org.mvnsearch.ddd.domain;

import org.mvnsearch.ddd.domain.annotations.DomainEntity;

/**
 * base domain entity
 *
 * @author linux_china
 */
@DomainEntity
public interface BaseDomainEntity<ID> extends Identifiable<ID> {
    /**
     * get entity id
     *
     * @return entity id
     */
    ID getId();
}
