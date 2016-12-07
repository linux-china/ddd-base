package org.mvnsearch.demo.domain.event;

import org.mvnsearch.ddd.domain.events.BaseDomainEvent;
import org.mvnsearch.demo.domain.model.Account;

/**
 * login event
 *
 * @author linux_china
 */
public class LoginEvent extends BaseDomainEvent<Account> {

    public LoginEvent(Account account, String ip) {
        setPayload(account);
        setAttribute("ip", ip);
    }
}
