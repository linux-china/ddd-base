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


}
