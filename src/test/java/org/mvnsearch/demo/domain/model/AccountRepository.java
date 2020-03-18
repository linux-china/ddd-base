package org.mvnsearch.demo.domain.model;

import org.mvnsearch.ddd.domain.annotations.DomainRepository;

/**
 * account repository
 *
 * @author linux_china
 */
@DomainRepository
public interface AccountRepository {

    void create(Account account);

    void update(Account account);

    Account findOne(long id);
}
