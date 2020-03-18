package org.mvnsearch.ddd.domain;

import org.mvnsearch.ddd.domain.annotations.DomainAggregate;

/**
 * base domain aggregate
 *
 * @author linux_china
 */
@DomainAggregate
public interface BaseDomainAggregate<ID, ROOT extends BaseDomainEntity<ID>> extends BaseModel {
    /**
     * get aggregate root
     *
     * @return root object
     */
    ROOT getRoot();

    /**
     * get entity id
     *
     * @return entity id
     */
    ID getId();
}
