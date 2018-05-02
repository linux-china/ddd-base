package org.mvnsearch.demo.domain.event;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.mvnsearch.ddd.domain.events.DomainEvent;
import org.mvnsearch.demo.domain.model.Account;

/**
 * login event
 *
 * @author linux_china
 */
@JsonNaming
public class LoginEvent extends DomainEvent<Account> {

    public LoginEvent(Account account, String ip) {
        setData(account);
        setExtension("ip", ip);
    }
}
