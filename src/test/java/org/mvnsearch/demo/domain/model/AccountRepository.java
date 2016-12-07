package org.mvnsearch.demo.domain.model;

import org.mvnsearch.ddd.domain.annotations.DomainRepository;

/**
 * account repository
 *
 * @author linux_china
 */
@DomainRepository
public interface AccountRepository {

    public void create(Account account);

    public void update(Account account);

    public Account findOne(long id);
}
