package org.mvnsearch.ddd.domain;

import org.mvnsearch.ddd.domain.annotations.DomainAggregate;

/**
 * base domain aggregate
 *
 * @author linux_china
 */
@DomainAggregate
public interface BaseDomainAggregate<ID> extends Identifiable<ID> {

    /**
     * get entity id
     *
     * @return entity id
     */
    ID getId();
}
