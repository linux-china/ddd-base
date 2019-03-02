package org.mvnsearch.demo.domain.event;

import org.mvnsearch.ddd.domain.events.DomainEvent;
import org.mvnsearch.demo.domain.model.Account;

/**
 * account event
 *
 * @author linux_china
 */
public class AccountEvent extends DomainEvent<Account> {
    public static String CREATED_TYPE = "created";
    public static String BLOCKED_TYPE = "blocked";

    public AccountEvent(String type, Account account) {
        setDataContentType(type);
        setData(account);
    }
}
