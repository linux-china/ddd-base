package org.mvnsearch.demo.impl.domain.service;

import org.mvnsearch.demo.domain.event.AccountEvent;
import org.mvnsearch.demo.domain.model.Account;
import org.mvnsearch.demo.domain.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

/**
 * account service implementation
 *
 * @author linux_china
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private ApplicationEventPublisher eventPublisher;

    public void create(Account account) {
        //todo implement create logic
        eventPublisher.publishEvent(new AccountEvent(AccountEvent.CREATED_TYPE, account));
    }

    public void updatePassword(Long accountId, String oldPassword, String newPassword) {

    }

    public void resetPassword(Long accountId) {

    }
}
