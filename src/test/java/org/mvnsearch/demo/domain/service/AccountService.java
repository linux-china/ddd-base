package org.mvnsearch.demo.domain.service;

import org.mvnsearch.ddd.domain.annotations.DomainService;
import org.mvnsearch.demo.domain.model.Account;

/**
 * account service
 *
 * @author linux_china
 */
@DomainService
public interface AccountService {

    void create(Account account);

    void updatePassword(Long accountId, String oldPassword, String newPassword);

    void resetPassword(Long accountId);
}
